package Server;

import Const.Constants;
import Server.Queries;
import Server.QueryString;
import Utils.JsonUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Denis on 18.10.2014.
 */
public class Dictionary {
    public interface ITranslate{
        public void success(String str);
        public void error(String err);
    }
    public static void translate(String word, String lang, final ITranslate iTranslate){
        QueryString q = null;
        try {
            q = new QueryString()
                    .add("key", Constants.KEY)
                    .add("lang", lang)
                    .add("text", word);
        } catch (UnsupportedEncodingException e) {
            iTranslate.error(e.getMessage());
        }
        Queries.get(Constants.URL, q, new Queries.IServerAnswer() {
            @Override
            public void success(String str) {
                String s = null;
                try {
                    s = JsonUtils.parser(str);
                    iTranslate.success(s);
                } catch (Exception e) {
                    iTranslate.error("нет перевода");
                }
            }

            @Override
            public void error(String err) {
                iTranslate.error(err);
            }
        });
    }
}
