import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Document page = Jsoup.connect("http://books.toscrape.com/").timeout(6000).get();
            Elements links = page.select("div.side_categories a");
            for(Element link : links){
                System.out.println(link.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
