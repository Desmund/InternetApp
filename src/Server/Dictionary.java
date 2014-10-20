package Server;

import Const.Constants;
import Utils.JsonUtils.JsonTranslate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Denis on 18.10.2014.
 */
public class Dictionary {
    public interface ITranslate{
        public void success(ArrayList<String> str);
        public void success();
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
        Queries.get(Constants.URL_TRANSLATE, q, new Queries.IServerAnswer() {
            @Override
            public void success(String str) {
                ArrayList<String> s = null;
                try {
                    s = JsonTranslate.parser(str);
                    if(s.size()!=0)
                        iTranslate.success(s);
                    else
                        iTranslate.success();
                } catch (Exception e) {
                    iTranslate.error("Такого слова в словаре нет!");
                }
            }

            @Override
            public void error(String err) {
                iTranslate.error(err);
            }
        });
    }
}
