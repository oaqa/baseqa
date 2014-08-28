package edu.cmu.lti.oaqa.baseqa.collection.json.gson;

public final class Triple {

  private String s;

  private String p;

  private String o;

  public Triple(String s, String p, String o) {
    super();
    this.s = s;
    this.p = p;
    this.o = o;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((o == null) ? 0 : o.hashCode());
    result = prime * result + ((p == null) ? 0 : p.hashCode());
    result = prime * result + ((s == null) ? 0 : s.hashCode());
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
    Triple other = (Triple) obj;
    if (o == null) {
      if (other.o != null)
        return false;
    } else if (!o.equals(other.o))
      return false;
    if (p == null) {
      if (other.p != null)
        return false;
    } else if (!p.equals(other.p))
      return false;
    if (s == null) {
      if (other.s != null)
        return false;
    } else if (!s.equals(other.s))
      return false;
    return true;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  public String getP() {
    return p;
  }

  public void setP(String p) {
    this.p = p;
  }

  public String getO() {
    return o;
  }

  public void setO(String o) {
    this.o = o;
  }

}