package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.github.julman99.gsonfire.GsonFireBuilder;
import com.github.julman99.gsonfire.TypeSelector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class TrainingSet {

  public static final class QuestionTypeSelector implements TypeSelector<TrainingQuestion> {
    @Override
    public Class<? extends TrainingQuestion> getClassForElement(JsonElement readElement) {
      JsonElement type = readElement.getAsJsonObject().get("type");
      if (null == type) {
        return TrainingQuestion.class;
      }
      String typeStr = type.getAsString();
      if (typeStr.equals("factoid")) {
        return TrainingFactoidQuestion.class;
      } else if (typeStr.equals("yesno")) {
        return TrainingYesNoQuestion.class;
      } else if (typeStr.equals("list")) {
        return TrainingListQuestion.class;
      } else if (typeStr.equals("summary")) {
        return TrainingSummaryQuestion.class;
      } else {
        return TrainingQuestion.class;
      }
    }
  }

  private static Gson gson = new GsonFireBuilder().registerTypeSelector(TrainingQuestion.class,
          new QuestionTypeSelector()).createGson();

  private List<? extends TrainingQuestion> questions;

  public TrainingSet(List<? extends TrainingQuestion> answers) {
    this.questions = answers;
  }

  public static List<? extends TrainingQuestion> load(Reader reader) {
    TrainingSet input = gson.fromJson(reader, TrainingSet.class);
    return input.questions;
  }

  public static List<? extends TrainingQuestion> load(InputStream stream) {
    return load(new InputStreamReader(stream));
  }
  
  public static String dump(List<? extends TrainingQuestion> answers) {
    TrainingSet output = new TrainingSet(answers);
    return gson.toJson(output, TrainingSet.class);
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
    TrainingSet other = (TrainingSet) obj;
    if (questions == null) {
      if (other.questions != null)
        return false;
    } else if (!questions.equals(other.questions))
      return false;
    return true;
  }

}
