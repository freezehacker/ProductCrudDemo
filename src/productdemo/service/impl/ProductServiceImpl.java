package productdemo.service.impl;

import productdemo.bean.Product;
import productdemo.repository.IProductRepository;
import productdemo.repository.impl.ProductRepositoryImpl;
import productdemo.service.IProductService;

import java.util.List;

/**
 * Created by sjk on 17-2-8.
 */
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.select(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.insert(product);
    }

    @Override
    public void removeProductById(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public void modifyProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.search(name);
    }
}
