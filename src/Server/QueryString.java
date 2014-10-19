package Server; /**
 * Created by Denis on 17.10.2014.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {

    private StringBuffer query;

    public QueryString(String name, String value)throws UnsupportedEncodingException{
        add(name,value);
    }

    public QueryString(){
        query = new StringBuffer();
    }

    public synchronized QueryString add(Object name, Object value)throws UnsupportedEncodingException{
        if (!query.toString().trim().equals("")) query.append("&");
        query.append(URLEncoder.encode(name.toString(),"UTF-8"));
        query.append("=");
        query.append(URLEncoder.encode(value.toString(),"UTF-8"));
        return this;
    }

    @Override
    public String toString() {
        return  query.toString();
    }
}
