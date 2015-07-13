package ua.gleb.dao;

import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.UpdateOpsImpl;
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

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
}
