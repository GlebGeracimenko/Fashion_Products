import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gleb.parser.URLParser;

/**
 * Created by gleb on 12.07.15.
 */

public class Test {

    public static void main(String[] args) {

        SavingProducts.saveProducts(URLParser.getLinks("http://www.coast-stores.com/all-dresses/dept/fcp-category/list"));
        System.out.println("End!");

    }
}
