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

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
}
