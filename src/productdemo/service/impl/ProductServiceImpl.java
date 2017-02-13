package productdemo.service.impl;

import productdemo.bean.Product;
import productdemo.constant.PagerConst;
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

    @Override
    public List<Product> getProducts(int pageSize, int pageIndex) {

        /**
         * 由Service层保证参数合法性，原因：
         *  1、API是基于Service层的服务调用
         *  2、Repository层最好是简单的完成数据库功能，不考虑参数合法性
         */

        if (pageSize < 0) {
            pageSize = PagerConst.PAGE_SIZE;
        } else if (pageSize > PagerConst.MAX_PAGE_SIZE) {   // 每页记录数不能大于某个值
            pageSize = PagerConst.MAX_PAGE_SIZE;
        }

        if (pageIndex < 0) {
            pageIndex = PagerConst.PAGE_INDEX;
        }


        return productRepository.select(pageSize, pageIndex);
    }

    @Override
    public int countAllProducts() {
        return productRepository.countAll();
    }
}
