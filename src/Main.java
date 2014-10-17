/**
 * Created by Denis on 17.10.2014.
 */
public class Main {
    private static String key = "dict.1.1.20141015T173845Z.3c9e418789463529.ff0dbbfe1344ced63658bdad3c92284237de4362";
    private static String lang = "en-ru";
    private static String text = "mother";
    private static String url = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";

    public static void main(String[] args) throws Exception{
        QueryString q = new QueryString()
            .add("key",key)
            .add("lang",lang)
            .add("text",text);
        GetQuery g = new GetQuery();
        String json;
        json = g.get(url, q);
        JsonUtils.parser(json);
    }
}
