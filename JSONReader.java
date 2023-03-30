import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class JsonReader {
    public static JSONObject readJsonFromFile(String filePath) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return new JSONObject(content);
    }
    
    public static void main(String[] args) throws JSONException, IOException {
        JSONObject json = readJsonFromFile("/path/to/file.json");
        System.out.println(json.toString());
    }
}
