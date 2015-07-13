package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 13.07.15.
 */
public class URLParser {

    public static List<String> getLinks(String url) {
        List<String> links = null;
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a[class = title]");
            links = new ArrayList<String>();
            for (Element element : elements) {
                links.add(element.attr("abs:href"));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    public static void pageParsing(List<String> links) {
        for (String link : links) {
            try {
                System.out.println(link);
                Document document = Jsoup.connect(link).get();
                Element title = document.select("h1").first();
                Element price = document.select(".product-price").first();
                Element description = document.select(".info").first();
                Elements allStockSize = document.select(".in-stock, .low-stock");
                Elements images = document.select("div.product_altImages");
                System.out.println(images.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}