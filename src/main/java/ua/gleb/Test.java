package ua.gleb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gleb.control.SavingProducts;
import ua.gleb.dao.IProductDao;
import ua.gleb.dao.ProductDaoImpl;
import ua.gleb.parser.URLParser;

/**
 * Created by gleb on 12.07.15.
 */

public class Test {

    public static final String URL = "http://www.coast-stores.com/all-dresses/dept/fcp-category/list";

    public static void main(String[] args) {
        SavingProducts.saveProducts(URLParser.getLinks(URL));
        System.out.println("End!");

    }
}
