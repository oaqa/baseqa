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

public class JdbcReportComponentBuilder extends Resource_ImplBase
        implements ReportComponentBuilder {

  private List<String> idFields;

  private List<String> measureFields;

  private String valueField;

  private String valueFormat;

  private String query;

  @Override
  public boolean initialize(ResourceSpecifier specifier, Map<String, Object> additionalParams)
          throws ResourceInitializationException {
    Splitter splitter = Splitter.on(',').trimResults();
    this.idFields = splitter.splitToList(((String) additionalParams.get("id")));
    this.measureFields = splitter.splitToList((String) additionalParams.get("measure"));
    this.valueField = (String) additionalParams.get("value");
    this.valueFormat = (String) additionalParams.get("format");
    this.query = (String) additionalParams.get("query");
    return true;
  }

  @Override
  public ReportComponent getReportComponent(String... args) {
    ImmutableTable.Builder<String, String, String> builder = ImmutableTable.builder();
    Set<String> measures = new HashSet<>();
    Set<String> ids = new HashSet<>();
    RowCallbackHandler handler = new RowCallbackHandler() {
      public void processRow(ResultSet rs) throws SQLException {
        // retrieve ids
        Map<String, String> field2id = new HashMap<>();
        for (String idField : idFields) {
          field2id.put(idField, rs.getString(idField));
        }
        String id = idFields.stream().map(field2id::get).collect(joining("/"));
        // retrieve measures
        Map<String, String> field2measure = new HashMap<>();
        for (String measureField : measureFields) {
          field2measure.put(measureField, rs.getString(measureField));
        }
        String measure = measureFields.stream().map(field2measure::get).collect(joining("/"));
        // add measure name to header
        measures.add(measure);
        // add keys/values to table
        if (!ids.contains(id)) {
          idFields.forEach(key -> builder.put(id, key, field2id.get(key)));
          ids.add(id);
        }
        // add measure name/value to table
        builder.put(id, measure, String.format(valueFormat, rs.getDouble(valueField)));
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
        List<String> headers = new ArrayList<>(idFields);
        measures.stream().sorted().forEach(headers::add);
        return headers;
      }
    };
  }

}
