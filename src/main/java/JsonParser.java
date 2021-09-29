import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;



public class JsonParser {
    private static final String Company = "company";
    private static final String Person = "person";
    private static final String Employee = "employee";
    private static final String NAME = "name";
    private static final int CONST = 1;
    String path = "C:\\Users\\andrei.lisa\\IdeaProjects\\JsonParser\\src\\main\\resources\\json\\file2.json";
    String path2 = "C:\\Users\\andrei.lisa\\IdeaProjects\\JsonParser\\src\\main\\resources\\json\\file.json";

    public void parserJSON(String filepath) {

        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(filepath));
            if (data.size() == CONST) {
                JSONObject obj1 = (JSONObject) data.get(Company);
                JSONObject obj2 = (JSONObject) obj1.get(Employee);
                JSONArray array = (JSONArray) obj2.get(Person);
                for (Object json1 : array) {
                    JSONObject jsonObject1 = (JSONObject) json1;
                    String name1 = (String) jsonObject1.get(NAME);
                    System.out.println(name1);
                }
            } else  if(data.size() > CONST) {
                JSONArray arr = (JSONArray) data.get(Person);
                for (Object json : arr) {
                    JSONObject jsonObject = (JSONObject) json;
                    String name = (String) jsonObject.get(NAME);
                    System.out.println(name);
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
