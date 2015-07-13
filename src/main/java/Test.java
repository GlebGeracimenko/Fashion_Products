import ua.gleb.dao.ProductDaoImpl;
import ua.gleb.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 12.07.15.
 */

public class Test {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext("ua.gleb");

        
        ProductDaoImpl productDao = context.getBean(ProductDaoImpl.class);

        List<String> list1 = new ArrayList<String>();
        list1.add("CHACHA");
        List<String> list2 = new ArrayList<String>();
        list2.add("PACKAGE");
        productDao.save(new Product("Test1", 456, "Test1", list1, list2));
    }
}
