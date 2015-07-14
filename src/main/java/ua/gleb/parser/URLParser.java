package ua.gleb.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 13.07.15.
 */
public class URLParser {

    /**
     *
     * @param url
     * @return links all products
     */
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

}