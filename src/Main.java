/**
 * Created by Denis on 17.10.2014.
 */
public class Main {
    private static String key = "dict.1.1.20141015T173845Z.3c9e418789463529.ff0dbbfe1344ced63658bdad3c92284237de4362";
    private static String lang = "en-ru";
    private static String text = "";
    private static String url = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";

    public static void main(String[] args) throws Exception{
        int finish = -1;
        int direction = -1;
        do{
            do{
                System.out.println("Выберите направление перевода");
                System.out.println("0 - ru->en" + '\n' + "1 - en->ru");
                direction = Utils.integerInput();
            }while(direction>1||direction<0);
            switch (direction){
                case 0 : lang = "ru-en";
                    break;
                case 1 : lang = "en-ru";
                    break;
            }
            while(text=="") {
                System.out.println("Введите слово для перевода");
                text = Utils.stringReader();
            }
            QueryString q = new QueryString()
                    .add("key", key)
                    .add("lang", lang)
                    .add("text", text);
            GetQuery g = new GetQuery();
            String json;
            json = g.get(url, q);
            System.out.println(JsonUtils.parser(json));
            System.out.println("0 - для выхода" + '\n' + "Любое положительное число - для продолжения");
            finish = Utils.integerInput();
        }while (finish!=0);
    }
}
