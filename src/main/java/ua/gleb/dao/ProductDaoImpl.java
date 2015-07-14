package ua.gleb.dao;

import ua.gleb.model.Product;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements IProductDao {

    @Autowired
    private Datastore datastore;

    public ProductDaoImpl() {

    }

    /**
     * @param product save in database
     */
    @Override
    public void save(Product product) {
        datastore.save(product);
    }

    /**
     * @param datastore
     */
    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
}
