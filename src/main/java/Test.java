import dao.IProductDao;
import dao.ProductDaoImpl;
import model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parser.URLParser;
import util.MongoDBConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 12.07.15.
 */

public class Test {

    public static void main(String[] args) {
        ProductDaoImpl productDao = new ProductDaoImpl();
        List<String> list1 = new ArrayList<String>();
        list1.add("CHACHA");
        List<String> list2 = new ArrayList<String>();
        list2.add("PACKAGE");
        productDao.save(new Product("Test1", 456, "Test1", list1, list2));
        URLParser.getLinks("http://www.coast-stores.com/all-dresses/dept/fcp-category/list");
    }
}
