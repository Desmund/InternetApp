import Menu.DictionaryMenu;
import Menu.WeatherMenu;
import Server.Dictionary;

import javax.rmi.CORBA.Util;

/**
 * Created by Denis on 17.10.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        char key =' ';

        while (true) {
            System.out.println("Нажмите" +  '\n' +
                    "t - для перехода в меню словоря" + '\n' +
                    "w - для перехода в меню погоды" + '\n' +
                    "e - для выхода"
            );
            key = Utils.InputOutputUtils.charReader();
            switch (key){
                case 't':
                    DictionaryMenu.printMenu();
                    break;
                case 'w':
                    WeatherMenu.printMenu();
                    break;
                case 'e':
                    System.exit(0);
            }
        }
    }
}
