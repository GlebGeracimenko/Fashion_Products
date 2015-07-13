package parser;

import java.net.URL;

/**
 * Created by gleb on 13.07.15.
 */
public class Test {
    public static void main(String[] args) {
        URLParser.pageParsing(URLParser.getLinks("http://www.coast-stores.com/all-dresses/dept/fcp-category/list"));
    }
}
