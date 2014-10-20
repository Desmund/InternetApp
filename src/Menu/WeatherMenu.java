package Menu;

import Const.Constants;
import Server.Dictionary;
import Utils.InputOutputUtils;
import java.util.ArrayList;

/**
 * Created by Denis on 20.10.2014.
 */
public class WeatherMenu {
    private static String country;
    private static String iso;
    public static void printMenu(){
        System.out.println("Введите город, погоду которого вы хотите узнать");
        country = InputOutputUtils.stringReader();
        System.out.println("Введите ISO страны, город которой вы только что ввели");
        iso = InputOutputUtils.stringReader();
        Dictionary.translate(country, Constants.LANG_RU_EN, new Dictionary.ITranslate() {
            @Override
            public void success(ArrayList<String> str) {
                country = str.get(0);
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
    }
}
