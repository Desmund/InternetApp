package Utils.JsonUtils;

import Structures.WeatherStruct;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Denis on 20.10.2014.
 */
public class JsonWeather {
    public static WeatherStruct parser(String str)throws Exception{
        JsonObject obj;
        JsonArray arr;
        WeatherStruct ws = new WeatherStruct();
        JsonParser jsonParser = new JsonParser();
        JsonElement el = jsonParser.parse(str);
        obj = (JsonObject) el;
        obj = (JsonObject) obj.get("coord");
        ws.setLon(obj.get("lon").getAsDouble());
        ws.setLat(obj.get("lat").getAsDouble());
        arr = (JsonArray) ((JsonObject) el).get("weather");
        obj = (JsonObject)arr.get(0);
        ws.setWeather(obj.get("description").getAsString());
        obj = (JsonObject) ((JsonObject) el).get("main");
        ws.setTemp(obj.get("temp").getAsDouble());
        ws.setTempMin(obj.get("temp_min").getAsDouble());
        ws.setTempMax(obj.get("temp_max").getAsDouble());
        ws.setHumidity(obj.get("humidity").getAsByte());
        ws.setPressure(obj.get("pressure").getAsDouble());
        obj = (JsonObject) ((JsonObject) el).get("wind");
        ws.setWindSpeed(obj.get("speed").getAsDouble());
        ws.setWindDeg(obj.get("deg").getAsDouble());
        return ws;
    }
}
