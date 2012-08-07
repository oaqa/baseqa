package edu.cmu.lti.oaqa.framework.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oaqa.model.Constituent;
import org.oaqa.model.ExternalResource;
import org.oaqa.model.TagInfo;

import edu.cmu.lti.oaqa.framework.JCasHelper;

/**
 * TOKEN type refers to the original token terms, and phrases refer to the name entities identified
 * by NameEntity.
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class Keyterm implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final int TOKEN = 0;

  public static final int PHRASE = 1;

  public static final int UNKNOWN = 2;

  private String text = null;

  private int sequenceId = -1;

  private int type = UNKNOWN;

  private Map<String, Set<String>> tag2sources = new HashMap<String, Set<String>>();

  private Map<String, Set<String>> concept2sources = new HashMap<String, Set<String>>();

  private Map<String, Set<String>> category2sources = new HashMap<String, Set<String>>();

  private Map<String, Set<String>> synonym2sources = new HashMap<String, Set<String>>();

  /**
   * Default constructor where sequenceId will be set -1, and type will be set <code>UNKNOWN</code>.
   * 
   * @param text
   *          token or phrase
   */
  public Keyterm(String text) {
    this.text = text;
  }

  public Keyterm(String text, int sequenceId, int type) {
    this.text = text;
    this.sequenceId = sequenceId;
    this.type = type;
  }

  public Keyterm(Constituent constituent) {
    text = constituent.getText();
    sequenceId = constituent.getSequence();
    type = constituent.getCType();
    for (TagInfo tag : JCasHelper.<TagInfo> fsIterator(constituent.getTags())) {
      addTag(tag.getTag(), tag.getSource());
    }
    for (ExternalResource resource : JCasHelper.<ExternalResource> fsIterator(constituent
            .getResources())) {
      addExternalResource(resource.getConcept(), resource.getCategory(),
              Arrays.asList(resource.getSynonyms().toArray()), resource.getSource());
    }
  }

  public void addTag(String tag, String source) {
    if (!tag2sources.containsKey(tag)) {
      tag2sources.put(tag, new HashSet<String>());
    }
    tag2sources.get(tag).add(source);
  }

  public void addConcept(String concept, String source) {
    if (concept == null) {
      return;
    }
    if (!concept2sources.containsKey(concept)) {
      concept2sources.put(concept, new HashSet<String>());
    }
    concept2sources.get(concept).add(source);
  }

  public void addCategory(String category, String source) {
    if (category == null) {
      return;
    }
    if (!category2sources.containsKey(category)) {
      category2sources.put(category, new HashSet<String>());
    }
    category2sources.get(category).add(source);
  }

  public void addSynonym(String synonym, String source) {
    if (synonym == null) {
      return;
    }
    if (!synonym2sources.containsKey(synonym)) {
      synonym2sources.put(synonym, new HashSet<String>());
    }
    synonym2sources.get(synonym).add(source);
  }

  public void addExternalResource(String concept, String category, List<String> synonyms,
          String source) {
    addConcept(concept, source);
    addCategory(category, source);
    if (synonyms == null) {
      return;
    }
    for (String synonym : synonyms) {
      addSynonym(synonym, source);
    }
  }

  public Set<String> getAllTagSources() {
    Set<String> allSources = new HashSet<String>();
    for (Set<String> sources : tag2sources.values()) {
      allSources.addAll(sources);
    }
    return allSources;
  }

  public Set<String> getAllResourceSources() {
    Set<String> allSources = new HashSet<String>();
    for (Set<String> sources : concept2sources.values()) {
      allSources.addAll(sources);
    }
    for (Set<String> sources : category2sources.values()) {
      allSources.addAll(sources);
    }
    for (Set<String> sources : synonym2sources.values()) {
      allSources.addAll(sources);
    }
    return allSources;
  }

  public String getTagBySource(String source) {
    for (String tag : tag2sources.keySet()) {
      if (tag2sources.get(tag).contains(source)) {
        return tag;
      }
    }
    return null;
  }

  public String getConceptBySource(String source) {
    for (String concept : concept2sources.keySet()) {
      if (concept2sources.get(concept).contains(source)) {
        return concept;
      }
    }
    return null;
  }

  public String getCategoryBySource(String source) {
    for (String category : category2sources.keySet()) {
      if (category2sources.get(category).contains(source)) {
        return category;
      }
    }
    return null;
  }

  public List<String> getSynonymsBySource(String source) {
    List<String> synonyms = new ArrayList<String>();
    for (String synonym : synonym2sources.keySet()) {
      if (synonym2sources.get(synonym).contains(source)) {
        synonyms.add(synonym);
      }
    }
    return synonyms;
  }

  public Set<String> getTags() {
    return tag2sources.keySet();
  }

  public Set<String> getConcepts() {
    return concept2sources.keySet();
  }

  public Set<String> getCategories() {
    return category2sources.keySet();
  }

  public Set<String> getSynonyms() {
    return synonym2sources.keySet();
  }

  public Set<String> getConceptSources(String concept) {
    return concept2sources.get(concept);
  }

  public Set<String> getCategorySources(String category) {
    return category2sources.get(category);
  }

  public Set<String> getSynonymSources(String synonym) {
    return synonym2sources.get(synonym);
  }

  public int getSequenceId() {
    return sequenceId;
  }

  public String getText() {
    return text;
  }

  public int getType() {
    return type;
  }

  public boolean isToken() {
    return type == TOKEN;
  }

  public boolean isPhrase() {
    return type == PHRASE;
  }

  @Override
  public String toString() {
    return text;
  }

}
