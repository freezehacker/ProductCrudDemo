package productdemo.service;

import productdemo.bean.Category;

import java.util.List;

/**
 * Created by sjk on 17-2-9.
 */
public interface ICategoryService {

    List<Category> getAllCategories();
}
