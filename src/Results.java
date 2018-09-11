
public class Results {
    org.jsoup.nodes.Document page;
    Results(org.jsoup.nodes.Document page){
        this.page = page;
    }
    int getNumber(String text){
        String pattern = "(.*) result.*";
        String number =  text.replaceAll(pattern,"$1");
        return Integer.parseInt(number);
    }
}
