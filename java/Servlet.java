import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class Servlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    String requestUrl = req.getRequestURI();
    String name = requestUrl.substring("/people/".length());
    Person person = Database.getInstance().getPerson(name);

    if (person != null) {
      String json = "{\n";
      json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
      json += "\"summary\": " + JSONObject.quote(person.getSummary()) + ",\n";
      json += "\"favColor\": " + JSONObject.quote(person.getFavColor()) + "\n";
      json += "}";
      res.getOutputStream().println(json);
    } else {
      res.getOutputStream().println("{}");
    }
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    String name = req.getParameter("name");
    String summary = req.getParameter("summary");
    String favColor = req.getParameter("favColor");

    Database.getInstance().putPerson(new Person(name, summary, favColor));
  }
}
