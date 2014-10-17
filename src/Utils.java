import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Denis on 17.10.2014.
 */
public class Utils {
    public static String readStreamToString(InputStream in,String encoding) throws IOException{
        StringBuffer b = new StringBuffer();
        InputStreamReader r = new InputStreamReader(in, encoding);
        int c;
        while ((c = r.read())!= -1){
            b.append((char)c);
        }
        return b.toString();
    }

    public static String stringReader(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }catch (Exception e){
            System.out.println("Ошибка при вводе строки!");
        }
        return null;
    }

    public static int integerInput(){
        int val = -1;
        while(val<0) {
            try {
                val = Integer.parseInt(stringReader());
                if(val<0)
                    System.out.println("Введено отрицательное число!Введите число >0");
            } catch (Exception e) {
                val = -1;
                System.out.println("Ошибка при вводе целого положительного числа!");
            }
        }
        return val;
    }
}
