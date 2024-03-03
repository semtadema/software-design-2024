package classes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class Level {

    public void index() {
        String filePath = "path/to/your/json/file.json"; // Replace with your JSON file path

        // Use try-with-resources to automatically close the file reader
        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON using Gson
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(reader).getAsJsonObject();
            gradle -q dependencies
            // Access JSON elements
            String value1 = jsonObject.get("key1").getAsString();
            int value2 = jsonObject.get("key2").getAsInt();

            // Print values
            System.out.println("Value 1: " + value1);
            System.out.println("Value 2: " + value2);
            // Add more logic to handle other JSON elements as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
