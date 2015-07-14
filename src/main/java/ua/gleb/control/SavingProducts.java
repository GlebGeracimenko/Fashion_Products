package ua.gleb.control;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gleb.dao.IProductDao;
import ua.gleb.dao.ProductDaoImpl;
import ua.gleb.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 13.07.15.
 */
public class SavingProducts {

    private static final ApplicationContext context = new AnnotationConfigApplicationContext("ua.gleb");
    private static IProductDao productDao = context.getBean(ProductDaoImpl.class);
    private static int count = 0;

    /**
     * @param links
     * parse page and save product in database
     */
    public static void saveProducts(List<String> links) {
        for (String link : links) {

            Document document = null;
            try {
                document = Jsoup.connect(link).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element title = document.select("h1").first();
            Element price = document.select(".product-price").first();
            Element description = document.select(".info").first();
            Elements allStockSize = document.select(".in-stock, .low-stock");
            Element image = document.select("a[class = zoom]").first();
            productDao.save(new Product(title.text(), priceHelper(price),
                    description.text(), sizeHelper(allStockSize), imagesHelper(image)));
            System.out.println(++count);
        }
    }

    /**
     * @param element
     * @return price product
     */
    private static double priceHelper(Element element) {
        String s = element.text();
        s = s.substring(s.indexOf("£") + 1, s.indexOf(".") + 3);
        return Double.parseDouble(s);
    }

    /**
     * @param elements
     * @return list all size in-stock and low-stock
     */
    private static List<String> sizeHelper(Elements elements) {
        List<String> list = new ArrayList<String>();
        for (Element element : elements) {
            list.add(element.text());
        }
        return list;
    }

    /**
     * @param element
     * @return list url images product
     */
    private static List<String> imagesHelper(Element element) {
        List<String> list = new ArrayList<String>();
        String s = element.attr("abs:href");
        list.add(s);
        for(int i = 1; i < 4; i++) {
            String s1 = s.substring(0, s.length() - 4) + "_" + i + s.substring(s.length() - 4, s.length());
            list.add(s1);
        }
        return list;
    }

}
