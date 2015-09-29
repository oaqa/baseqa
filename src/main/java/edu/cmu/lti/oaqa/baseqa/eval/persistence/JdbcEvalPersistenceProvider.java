package edu.cmu.lti.oaqa.baseqa.eval.persistence;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import edu.cmu.lti.oaqa.baseqa.eval.EvalPeristenceProvider;
import edu.cmu.lti.oaqa.baseqa.eval.Measure;
import edu.cmu.lti.oaqa.ecd.config.ConfigurableProvider;
import edu.cmu.lti.oaqa.ecd.phase.Trace;
import edu.cmu.lti.oaqa.framework.DataStoreImpl;
import edu.cmu.lti.oaqa.framework.eval.ExperimentKey;
import edu.cmu.lti.oaqa.framework.eval.Key;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcEvalPersistenceProvider extends ConfigurableProvider implements
        EvalPeristenceProvider {

  @Override
  public void insertPartialMeasurements(Key key, String sequenceId, String calculatorName,
          String evaluateeName, Map<Measure, Double> measure2value) {
    String sql = (String) getParameterValue("insert-partial-meaurements-query");
    List<Map.Entry<Measure, Double>> pairs = new ArrayList<>(measure2value.entrySet());
    DataStoreImpl.getInstance().jdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, key.getExperiment());
        ps.setString(2, key.getTrace().getTrace());
        ps.setString(3, calculatorName);
        ps.setString(4, evaluateeName);
        ps.setString(5, pairs.get(i).getKey().toString());
        ps.setDouble(6, pairs.get(i).getValue());
        ps.setString(7, sequenceId); // TODO: JDBC OAQA
        ps.setInt(8, key.getStage());
        ps.setString(9, key.getTrace().getTraceHash());
      }

      @Override
      public int getBatchSize() {
        return pairs.size();
      }
    });
  }

  @Override
  public Table<Key, Measure, List<Double>> selectPartialMeasurements(ExperimentKey experiment,
          String calculatorName, String evaluateeName) {
    String sql = (String) getParameterValue("select-partial-meaurements-query");
    Table<Key, Measure, List<Double>> counts = HashBasedTable.create();
    RowCallbackHandler handler = new RowCallbackHandler() {

      public void processRow(ResultSet rs) throws SQLException {
        Key key = new Key(rs.getString("experimentId"), new Trace(rs.getString("traceId")),
                rs.getInt("stage"));
        Measure measure = Measure.forName(rs.getString("measure"));
        if (!counts.contains(key, measure)) {
          counts.put(key, measure, new ArrayList<>());
        }
        counts.get(key, measure).add(rs.getDouble("value"));
      }
    };
    DataStoreImpl.getInstance().jdbcTemplate().query(sql, new PreparedStatementSetter() {

      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, experiment.getExperiment());
        ps.setInt(2, experiment.getStage());
        ps.setString(3, calculatorName);
        ps.setString(4, evaluateeName);
      }
    }, handler);
    return counts;
  }

  @Override
  public void deletePartialMeasurements(Key key, String sequenceId, String calculatorName,
          String evaluateeName) {
    String insert = (String) getParameterValue("delete-partial-meaurements-query");
    DataStoreImpl.getInstance().jdbcTemplate().update(insert, new PreparedStatementSetter() {

      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, key.getExperiment());
        ps.setString(2, key.getTrace().getTraceHash());
        ps.setString(3, sequenceId); // TODO: JDBC OAQA
        ps.setString(4, calculatorName);
        ps.setString(5, evaluateeName);
      }
    });
  }

  @Override
  public void insertAccumulatedMeasurements(Key key, String calculatorName, String evaluateeName,
          Map<Measure, Double> measure2value) {
    String sql = (String) getParameterValue("insert-accumulated-measurements-query");
    List<Map.Entry<Measure, Double>> pairs = new ArrayList<>(measure2value.entrySet());
    DataStoreImpl.getInstance().jdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, key.getExperiment());
        ps.setString(2, key.getTrace().getTrace());
        ps.setString(3, calculatorName);
        ps.setString(4, evaluateeName);
        ps.setString(5, pairs.get(i).getKey().toString());
        ps.setDouble(6, pairs.get(i).getValue());
        ps.setInt(7, key.getStage());
        ps.setString(8, key.getTrace().getTraceHash());
      }

      @Override
      public int getBatchSize() {
        return pairs.size();
      }
    });
  }

  @Override
  public void deleteAccumulatedMeasurements(ExperimentKey experiment, String calculatorName,
          String evaluateeName) {
    String sql = (String) getParameterValue("delete-accumulated-measurements-query");
    DataStoreImpl.getInstance().jdbcTemplate().update(sql, new PreparedStatementSetter() {

      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, experiment.getExperiment());
        ps.setInt(2, experiment.getStage());
        ps.setString(3, calculatorName);
        ps.setString(4, evaluateeName);
      }
    });
  }

}
