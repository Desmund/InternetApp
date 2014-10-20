package Server;

import Const.Constants;

/**
 * Created by Denis on 20.10.2014.
 */
public class Weather {
    public interface IWeather{
        public void success();
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
                //todo обработка json строки
            }

            @Override
            public void error(String err) {
                iWeather.error(err);
            }
        });
    }
}
