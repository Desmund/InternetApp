package Menu;

import Const.Constants;
import Server.Dictionary;
import Server.Weather;
import Structures.WeatherStruct;
import Utils.InputOutputUtils;
import java.util.ArrayList;

/**
 * Created by Denis on 20.10.2014.
 */
public class WeatherMenu {
    private static String country;
    private static String iso;

    public WeatherMenu() {
        super();
    }

    public static void printMenu(){
        int finish = -1;
        do {
            System.out.println("Введите город, погоду которого вы хотите узнать");
            country = InputOutputUtils.stringReader();
            System.out.println("Введите ISO страны, город которой вы только что ввели");
            iso = InputOutputUtils.stringReader();
            Dictionary.translate(country, Constants.LANG_RU_EN, new Dictionary.ITranslate() {
                @Override
                public void success(ArrayList<String> str) {
                    Weather.find(str.get(0),iso,new Weather.IWeather() {
                        @Override
                        public void success(WeatherStruct ws) {
                            System.out.println(ws.toString());
                        }
                        @Override
                        public void error(String err) {
                            System.out.println("Ошибка: "+err);
                        }
                    });
                }

                @Override
                public void success() {
                    System.out.println("Поверте правильность написания города!");
                }

                @Override
                public void error(String err) {
                    System.out.println("Ошибка: " + err.toString());
                }
            });
            System.out.println("Обработка информации..." + '\n' + "0 - для выхода" + '\n' + "Для продолжения работы нажмите любое положительное число");
            finish = InputOutputUtils.integerInput();
        } while (finish != 0);
    }
}
