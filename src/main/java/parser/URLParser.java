package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by gleb on 13.07.15.
 */
public class URLParser {

    public static List<String> getLinks(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(".title");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
