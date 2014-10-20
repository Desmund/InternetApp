package Server;

import Const.Constants;
import Structures.WeatherStruct;
import Utils.JsonUtils.JsonTranslate;
import Utils.JsonUtils.JsonWeather;

import java.util.ArrayList;

/**
 * Created by Denis on 20.10.2014.
 */
public class Weather {
    public interface IWeather{
        public void success(WeatherStruct ws);
        public void error(String err);
    }
    public static void find(String country, String iso, final IWeather iWeather){
        QueryString query = null;
        try{
            query = new QueryString()
            .add("q",country+","+iso);
        }catch (Exception e){
            iWeather.error(e.getMessage());
        }
        Queries.get(Constants.URL_WEATHER,query, new Queries.IServerAnswer(){
            @Override
            public void success(String str) {
                try {
                    WeatherStruct ws = JsonWeather.parser(str);
                    if(ws!=null)
                        iWeather.success(ws);
                    else
                        iWeather.error("Произошла ошибка!Попробуйте проверить введенные вами данные!");
                } catch (Exception e) {
                    iWeather.error("Произошла ошибка!");
                }
            }

            @Override
            public void error(String err) {
                iWeather.error(err);
            }
        });
    }
}
