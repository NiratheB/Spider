import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String siteUrl = "http://books.toscrape.com/";
        try {
            Document page = Jsoup.connect(siteUrl).timeout(6000).get();
            Elements links = page.select("div.side_categories a");
            for(Element link : links){
                String url = link.attr("href");
                page = Jsoup.connect(siteUrl+url).timeout(6000).get();
                Element results = page.selectFirst("form");
                Results r = new Results(page);
                System.out.println(link.text() +" - "+ r.getNumber(results.text()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
