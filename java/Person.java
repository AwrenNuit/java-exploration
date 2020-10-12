public class Person {
  private String name;
  private String summary;
  private String favColor;

  public Person(String name, String summary, String favColor) {
    this.name = name;
    this.summary = summary;
    this.favColor = favColor;
  }

  public String getName() {
    return name;
  }

  public String getSummary() {
    return summary;
  }

  public String getFavColor() {
    return favColor;
  }
}
