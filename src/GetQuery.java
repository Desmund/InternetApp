import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Denis on 17.10.2014.
 */
public class GetQuery {
    public static String get(String url,QueryString query) throws IOException{
        URLConnection con = new URL(url + "?" + query).openConnection();
        return Utils.readStreamToString(con.getInputStream(),"UTF-8");
    }
}
