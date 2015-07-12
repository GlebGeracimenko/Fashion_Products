package util;

import com.mongodb.MongoClient;
import model.Product;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gleb on 11.07.15.
 */
@Configuration
@ComponentScan
public class MongoDBConnection {



    @Bean
    public Datastore connection() {
        Datastore datastore = null;
        if (datastore == null) {
            Morphia morphia = new Morphia();
            morphia.map(Product.class);
            datastore = morphia.createDatastore(new MongoClient(), "Fashion_Products");
            datastore.ensureIndexes();
        }
        return datastore;
    }

}
