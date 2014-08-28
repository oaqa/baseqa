package edu.cmu.lti.oaqa.baseqa.report;

import static java.util.stream.Collectors.joining;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.resource.Resource_ImplBase;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;

import edu.cmu.lti.oaqa.framework.DataStoreImpl;
import edu.cmu.lti.oaqa.framework.report.ReportComponent;
import edu.cmu.lti.oaqa.framework.report.ReportComponentBuilder;

public class JdbcReportComponentBuilder extends Resource_ImplBase implements ReportComponentBuilder {

  private List<String> keys;

  private String measureField;

  private String valueField;

  private String valueFormat;

  private String query;

  @Override
  public boolean initialize(ResourceSpecifier specifier, Map<String, Object> additionalParams)
          throws ResourceInitializationException {
    this.keys = Splitter.on(',').trimResults().splitToList(((String) additionalParams.get("keys")));
    this.measureField = (String) additionalParams.get("measure");
    this.valueField = (String) additionalParams.get("value");
    this.valueFormat = (String) additionalParams.get("format");
    this.query = (String) additionalParams.get("query");
    return true;
  }

  @Override
  public ReportComponent getReportComponent(String... args) {
    ImmutableTable.Builder<String, String, String> builder = ImmutableTable.builder();
    Set<String> measures = new HashSet<>();
    measures.addAll(keys);
    Set<String> rowIds = new HashSet<>();
    RowCallbackHandler handler = new RowCallbackHandler() {
      public void processRow(ResultSet rs) throws SQLException {
        Map<String, String> key2value = new HashMap<>();
        for (String key : keys) {
          key2value.put(key, rs.getString(key));
        }
        String rowId = keys.stream().map(key -> key2value.get(key)).collect(joining("/"));
        String measure = rs.getString(measureField);
        // add measure name to header
        measures.add(measure);
        // add measure name/value to table
        builder.put(rowId, measure, String.format(valueFormat, rs.getDouble(valueField)));
        // add keys/values to table
        if (!rowIds.contains(rowId)) {
          keys.stream().forEach(key -> builder.put(rowId, key, key2value.get(key)));
          rowIds.add(rowId);
        }
      }
    };
    PreparedStatementSetter pss = new PreparedStatementSetter() {
      public void setValues(PreparedStatement ps) throws SQLException {
        for (int i = 0; i < args.length; i++) {
          ps.setString(i + 1, args[i]);
        }
      }
    };
    DataStoreImpl.getInstance().jdbcTemplate().query(query, pss, handler);
    return new ReportComponent() {
      @Override
      public Table<String, String, String> getTable() {
        return builder.build();
      }

      @Override
      public List<String> getHeaders() {
        return new ArrayList<>(measures);
      }
    };
  }
}
