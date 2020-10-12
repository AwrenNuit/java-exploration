import java.util.HashMap;
import java.util.Map;

public class Database {
  private Map<String, Person> people = new HashMap<>();
  private static Database instance = new Database();

  public static Database getInstance() {
    return instance;
  }

  private Database() {
    people.put("Angela", new Person("Angela", "Really likes birds and exercise", "Blue"));
    people.put("Awren", new Person("Awren", "Lives in an old, drafty house.", "Autumn tones"));
    people.put("Ivy", new Person("Ivy", "Makes really, really good music.", "Black and black-adjacent colors"));
    people.put("Juniper", new Person("Juniper", "Might be from outer space. ((Definitely is))", "ALL THE COLORS"));
  }

  public Person getPerson(String name) {
    return people.get(name);
  }

  public void putPerson(Person person) {
    people.put(person.getName(), person);
  }
}
