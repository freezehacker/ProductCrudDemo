package productdemo.bean;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by sjk on 17-2-8.
 */
public class Product {

    /*
     * CREATE TABLE `Product` (
          `prod_id` int(11) NOT NULL AUTO_INCREMENT,
          `prod_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
          `prod_name` varchar(50) NOT NULL,
          `prod_price` decimal(8,2) NOT NULL DEFAULT '0.00',
          `prod_amount` int(11) NOT NULL DEFAULT '1',
          `prod_last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          `prod_category` int(11) NOT NULL,

          PRIMARY KEY (`prod_id`),
          KEY `fk_product_category` (`prod_category`),
          CONSTRAINT `fk_product_category` FOREIGN KEY (`prod_category`) REFERENCES `Category` (`cat_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8
     */

    private Integer id; // 唯一
    private Date register;  // 登记日期
    private String name;
    private float price;
    private int amount;
    private Category category;

    // 解析HTTP参数，构造bean
    // 也可以直接通过BeanUtils
    public static Product fromRequest(HttpServletRequest request) {
        Product product = new Product();

        // 因为id字段只有在“修改商品”的时候才会存在，所以要特殊处理
        String id = request.getParameter("id");
        if (id != null) {
            product.setId(Integer.valueOf(id));
        }

        product.setName(request.getParameter("name"));
        product.setPrice(Float.valueOf(request.getParameter("price")));
        product.setAmount(Integer.valueOf(request.getParameter("amount")));

        Category category = new Category();
        category.setId(Integer.valueOf(request.getParameter("catId")));
        //category.setName(request.getParameter("catName"));
        product.setCategory(category);

        return product;
    }

    // 计算该项总价
    public float getSumPrice() {
        return amount * price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
