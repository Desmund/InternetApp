import com.google.gson.*;

import java.math.BigDecimal;

/**
 * Created by Denis on 17.10.2014.
 */
public class JsonUtils {
    public static String parser(String str) throws Exception{
        StringBuffer b = new StringBuffer();
        JsonParser jsonParser = new JsonParser();
        JsonElement el = jsonParser.parse(str);
        JsonArray arr = (JsonArray)((JsonObject) el).get("def");
        JsonObject obj = (JsonObject) arr.get(0);
        obj = (JsonObject)((JsonArray)obj.get("tr")).get(0);
        b.append(obj.get("text").toString());
        arr = (JsonArray) obj.get("syn");
        if (arr!=null) {
            for(int i = 0; i < arr.size(); i++){
                b.append(", ");
                obj = (JsonObject) arr.get(i);
                b.append(obj.get("text").toString());
            }
        }
        return b.toString();
    }
}
