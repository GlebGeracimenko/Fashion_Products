import parser.URLParser;

import java.net.URLClassLoader;

/**
 * Created by gleb on 13.07.15.
 */
public class Test {
    public static void main(String[] args) {
        SavingProducts.saveProducts(URLParser.getLinks("http://www.coast-stores.com/all-dresses/dept/fcp-category/list"));
        System.out.println("end");
    }
}
