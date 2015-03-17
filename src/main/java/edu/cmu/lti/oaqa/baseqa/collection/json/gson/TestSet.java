package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import com.github.julman99.gsonfire.GsonFireBuilder;
import com.github.julman99.gsonfire.TypeSelector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TestSet {

  public static class QuestionTypeSelector implements TypeSelector<TestQuestion> {
    @Override
    public Class<? extends TestQuestion> getClassForElement(JsonElement readElement) {
      JsonElement type = readElement.getAsJsonObject().get("type");
      if (null == type) {
        return TestQuestion.class;
      }
      String typeStr = type.getAsString();
      if (typeStr.equals("factoid")) {
        return TestFactoidQuestion.class;
      } else if (typeStr.equals("yesno")) {
        return TestYesNoQuestion.class;
      } else if (typeStr.equals("list")) {
        return TestListQuestion.class;
      } else if (typeStr.equals("summary")) {
        return TestSummaryQuestion.class;
      } else {
        return TestQuestion.class;
      }
    }
  }

  public static class QuestionSerializer implements JsonSerializer<TestQuestion> {
    @Override
    public JsonElement serialize(TestQuestion src, Type typeOfSrc, JsonSerializationContext context) {
      switch (src.getType()) {
        case factoid:
          return context.serialize(src, TestFactoidQuestion.class);
        case yesno:
          return context.serialize(src, TestYesNoQuestion.class);
        case list:
          return context.serialize(src, TestListQuestion.class);
        case summary:
          return context.serialize(src, TestSummaryQuestion.class);
        default:
          return context.serialize(src, TestQuestion.class);
      }
    }
  }

  private List<? extends TestQuestion> questions;

  public TestSet(List<? extends TestQuestion> answers) {
    this.questions = answers;
  }

  public static List<? extends TestQuestion> load(Reader reader) {
    Gson gson = new GsonFireBuilder().registerTypeSelector(TestQuestion.class,
            new QuestionTypeSelector()).createGson();
    TestSet input = gson.fromJson(reader, TestSet.class);
    return input.questions;
  }

  public static List<? extends TestQuestion> load(InputStream stream) {
    return load(new InputStreamReader(stream));
  }

  public static String dump(List<? extends TestQuestion> answers) {
    Gson gson = new GsonBuilder().registerTypeAdapter(TestQuestion.class, new QuestionSerializer())
            .setPrettyPrinting().create();
    TestSet output = new TestSet(answers);
    return gson.toJson(output, TestSet.class);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((questions == null) ? 0 : questions.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestSet other = (TestSet) obj;
    if (questions == null) {
      if (other.questions != null)
        return false;
    } else if (!questions.equals(other.questions))
      return false;
    return true;
  }

}
