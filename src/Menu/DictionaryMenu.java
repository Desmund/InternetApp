package Menu;

import Const.Constants;
import Server.Dictionary;
import Utils.InputOutputUtils;
import java.util.ArrayList;

/**
 * Created by Denis on 20.10.2014.
 */


public class DictionaryMenu {
    private static String text = null;
    private static String lang;

    public static void printMenu() {
        int finish = -1;
        int direction = -1;
        do {
            do {
                System.out.println("Выберите направление перевода");
                System.out.println("0 - ru->en" + '\n' + "1 - en->ru");
                direction = InputOutputUtils.integerInput();
            } while (direction > 1 || direction < 0);
            switch (direction) {
                case 0:
                    lang = Constants.LANG_RU_EN;
                    break;
                case 1:
                    lang = Constants.LANG_EN_RU;
                    break;
            }
            while (text == null) {
                System.out.println("Введите слово для перевода");
                text = InputOutputUtils.stringReader();
            }
            Dictionary.translate(text, lang, new Dictionary.ITranslate() {
                @Override
                public void success(ArrayList<String> str) {
                    System.out.println("Перевод слова " + text + " : ");
                    for (String s : str)
                        System.out.println(s);
                }

                @Override
                public void success() {
                    System.out.println("Нет перевода для слова " + text);
                }

                @Override
                public void error(String err) {
                    System.out.println("Ошибка: " + err.toString());
                }
            });
            System.out.println("Обработка информации..." + '\n' + "0 - для выхода" + '\n' + "Для продолжения работы нажмите любое положительное число");
            finish = InputOutputUtils.integerInput();
            text = null;
        } while (finish != 0);
    }
}
