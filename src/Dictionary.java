import java.io.UnsupportedEncodingException;

/**
 * Created by Denis on 18.10.2014.
 */
public class Dictionary {
    public interface ITranslate{
        public void succsess(String str);
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
        GetQuery.get(Constants.URL,q,new GetQuery.IServerAnswer() {
            @Override
            public void succsess(String str) {
                String s = null;
                try {
                    s = JsonUtils.parser(str);
                    iTranslate.succsess(s);
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
