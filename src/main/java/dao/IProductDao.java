package dao;

import model.Product;

/**
 * Created by gleb on 12.07.15.
 */
public interface IProductDao {

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    void find(String title);

}
