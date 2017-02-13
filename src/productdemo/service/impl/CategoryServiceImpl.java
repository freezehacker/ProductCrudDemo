package productdemo.service.impl;

import productdemo.bean.Category;
import productdemo.repository.ICategoryRepository;
import productdemo.repository.impl.CategoryRepositoryImpl;
import productdemo.service.ICategoryService;

import java.util.List;

/**
 * Created by sjk on 17-2-9.
 */
public class CategoryServiceImpl implements ICategoryService {

    private ICategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.selectAll();
    }
}
