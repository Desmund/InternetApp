package Server;

import Utils.InputOutputUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Denis on 17.10.2014.
 */
public abstract class Queries {
    public interface IServerAnswer{
        public void success(String str);
        public void error(String err);
    }

    public static void get(final String url,final QueryString query,final IServerAnswer iServerAnswer){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection con = new URL(url + "?" + query).openConnection();
                    iServerAnswer.success(InputOutputUtils.readStreamToString(con.getInputStream(), "UTF-8"));
                } catch (IOException e) {
                    iServerAnswer.error(e.getMessage());
                }
            }
        }).start();
    }
}
