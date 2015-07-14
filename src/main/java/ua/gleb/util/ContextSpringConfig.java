package ua.gleb.util;

import com.mongodb.MongoClient;
import ua.gleb.model.Product;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class ContextSpringConfig { // ContextSpringConfig

    private Datastore datastore;

    @Bean
    public Datastore connection() {
        //always null must be a bean
        if (datastore == null) {
            Morphia morphia = new Morphia();
            morphia.map(Product.class);
            datastore = morphia.createDatastore(new MongoClient("localhost", 27017), "Fashion_Products");
            datastore.ensureIndexes();
        }
        return datastore;
    }

}
