package dao;

import model.Product;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import util.MongoDBConnection;

/**
 * Created by gleb on 12.07.15.
 */

@Component
public class ProductDaoImpl implements IProductDao {

    final private Datastore datastore;

    @Autowired
    public ProductDaoImpl() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoDBConnection.class);
        datastore = context.getBean(Datastore.class);
    }

    @Override
    public void save(Product product) {
        datastore.save(product);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void find(String title) {

    }

}
