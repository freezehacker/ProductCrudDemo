package productdemo.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.log4j.Logger;
import productdemo.bean.Category;
import productdemo.bean.Product;
import productdemo.repository.IProductRepository;
import productdemo.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjk on 17-2-8.
 */
public class ProductRepositoryImpl implements IProductRepository {

    private static Logger logger = Logger.getLogger(ProductRepositoryImpl.class);

    @Override
    public void insert(Product product) {
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql = "INSERT INTO `Product`(`prod_name`, `prod_price`, `prod_amount`, `prod_category`) VALUES (?,?,?,?)";
        try {
            queryRunner.update(
                    sql,
                    new Object[]{product.getName(), product.getPrice(), product.getAmount(), product.getCategory().getId()});
        } catch (SQLException sqle) {
            logger.error(sqle);
        }
    }

    @Override
    public void delete(Integer id) {
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql = "DELETE FROM `Product` WHERE `prod_id`=?";
        try {
            queryRunner.update(sql, id);
        } catch (SQLException sqle) {
            logger.error(sqle);
        }
    }

    @Override
    public void update(Product product) {
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql = "UPDATE `Product` " +
                "SET `prod_name`=?, `prod_price`=?, `prod_amount`=?, `prod_category`=? " +
                "WHERE `prod_id`=?";
        try {
            queryRunner.update(
                    sql,
                    new Object[]{product.getName(), product.getPrice(), product.getAmount(), product.getCategory().getId(), product.getId()});
        } catch (SQLException sqle) {
            logger.error(sqle);
        }
    }

    @Override
    public Product select(Integer id) {
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql = "SELECT * " +
                "FROM `Product` P INNER JOIN `Category` C ON P.`prod_category`=C.`cat_id` " +
                "WHERE `prod_id`=?";
        try {
            return queryRunner.query(sql, new ResultSetHandler<Product>() {
                @Override
                public Product handle(ResultSet rs) throws SQLException {
                    Product ret = null;
                    if (rs.next()) {
                        ret = new Product();

                        ret.setId(rs.getInt("prod_id"));
                        ret.setPrice(rs.getFloat("prod_price"));
                        ret.setAmount(rs.getInt("prod_amount"));
                        ret.setRegister(rs.getDate("prod_reg"));
                        ret.setName(rs.getString("prod_name"));
                        Category category = new Category();
                        category.setId(rs.getInt("cat_id"));
                        category.setName(rs.getString("cat_name"));
                        ret.setCategory(category);
                    }
                    return ret;
                }
            }, id);
        } catch (SQLException sqle) {
            logger.error(sqle);
            return null;
        }
    }

    @Override
    public List<Product> selectAll() {
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql = "SELECT * " +
                "FROM `Product` P INNER JOIN `Category` C ON P.`prod_category`=C.`cat_id`;";
        try {
            return queryRunner.query(sql, new ResultSetHandler<List<Product>>() {
                @Override
                public List<Product> handle(ResultSet resultSet) throws SQLException {
                    List<Product> ret = new ArrayList<>();
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setName(resultSet.getString("prod_name"));
                        product.setAmount(resultSet.getInt("prod_amount"));
                        product.setPrice(resultSet.getFloat("prod_price"));
                        product.setId(resultSet.getInt("prod_id"));
                        Category category = new Category();
                        category.setId(resultSet.getInt("cat_id"));
                        category.setName(resultSet.getString("cat_name"));
                        product.setCategory(category);
                        ret.add(product);
                    }
                    return ret;
                }
            });
        } catch (SQLException sqle) {
            logger.error(sqle);
            return null;
        }
    }

    @Override
    public List<Product> search(String name) {
        QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
        final String SQL = "SELECT * " +
                "FROM `Product` P INNER JOIN `Category` C ON P.`prod_category`=C.`cat_id` " +
                "WHERE P.`prod_name` LIKE ?";
        //logger.debug("name is: " + name);
        try {
            return runner.query(
                    SQL,
                    new ResultSetHandler<List<Product>>() {
                        @Override
                        public List<Product> handle(ResultSet resultSet) throws SQLException {
                            List<Product> products = new ArrayList<>();
                            while (resultSet.next()) {
                                Product product = new Product();
                                product.setName(resultSet.getString("prod_name"));
                                product.setAmount(resultSet.getInt("prod_amount"));
                                product.setPrice(resultSet.getFloat("prod_price"));
                                product.setId(resultSet.getInt("prod_id"));
                                Category category = new Category();
                                category.setId(resultSet.getInt("cat_id"));
                                category.setName(resultSet.getString("cat_name"));
                                product.setCategory(category);
                                products.add(product);
                            }
                            return products;
                        }
                    },
                    "%" + name + "%");
        } catch (SQLException sqle) {
            logger.error(sqle);
            return null;
        }
    }
}
