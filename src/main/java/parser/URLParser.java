package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
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


    private static String getHTML(String link) {
        BufferedReader reader = null;
        StringBuilder builder = null;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String s;
            builder = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                builder.append(s + "\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

}