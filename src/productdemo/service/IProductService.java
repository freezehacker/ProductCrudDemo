package productdemo.service;

import productdemo.bean.Product;

import java.util.List;

/**
 * Created by sjk on 17-2-8.
 */
public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    void addProduct(Product product);

    void removeProductById(Integer id);

    void modifyProduct(Product product);    // 实际上也是根据id来辨识

    List<Product> searchProductsByName(String name);
}
