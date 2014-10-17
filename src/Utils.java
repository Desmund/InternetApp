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
}
