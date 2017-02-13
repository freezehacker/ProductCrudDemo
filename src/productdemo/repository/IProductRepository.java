package productdemo.repository;

import productdemo.bean.Product;

import java.util.List;

/**
 * Created by sjk on 17-2-8.
 * 商品的CRUD
 */
public interface IProductRepository {

    void insert(Product product);

    void delete(Integer id);

    void update(Product product);

    Product select(Integer id);

    List<Product> selectAll();

    //

    List<Product> search(String name);

    List<Product> select(int pageSize, int pageIndex);

    int countAll();
}
