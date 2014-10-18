/**
 * Created by Denis on 17.10.2014.
 */
public class Main {

    private static String text = null;
    private static String lang;

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
                case 0 : lang = Constants.LANG_EN_RU;
                    break;
                case 1 : lang = Constants.LANG_EN_RU;
                    break;
            }
            while(text==null) {
                System.out.println("Введите слово для перевода");
                text = Utils.stringReader();
            }
            QueryString q = new QueryString()
                    .add("key", Constants.KEY)
                    .add("lang", lang)
                    .add("text", text);
            //todo исправить строку 47.
            GetQuery.get(Constants.URL,q,new GetQuery.IServerAnswer() {
                @Override
                public void succsess(String str) {
                    String s = JsonUtils.parser(str);
                    if(s!=null) {
                        System.out.println("Перевод слова " + text + " : " +s);
                    }else
                        System.out.println("Нет перевода для слова " + text);
                }
                @Override
                public void error(String err) {
                    System.out.println("Ошибка:" + err.toString());
                }
            });
            System.out.println("0 - для выхода" + '\n' + "Любое положительное число - для продолжения");
            finish = Utils.integerInput();
            text = null;
        }while (finish!=0);
    }
}
