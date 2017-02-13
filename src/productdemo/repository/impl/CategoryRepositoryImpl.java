package productdemo.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import productdemo.bean.Category;
import productdemo.repository.ICategoryRepository;
import productdemo.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjk on 17-2-9.
 */
public class CategoryRepositoryImpl implements ICategoryRepository {

    @Override
    public List<Category> selectAll() {
        try {
            QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
            return runner.query("SELECT * FROM `Category`", new ResultSetHandler<List<Category>>() {
                @Override
                public List<Category> handle(ResultSet rs) throws SQLException {
                    List<Category> categories = new ArrayList<>();
                    while (rs.next()) {
                        Category category = new Category();

                        category.setId(rs.getInt("cat_id"));
                        category.setName(rs.getString("cat_name"));

                        categories.add(category);
                    }
                    return categories;
                }
            });
        } catch (SQLException sqle) {
            return null;
        }
    }
}
