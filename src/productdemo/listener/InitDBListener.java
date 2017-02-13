package productdemo.listener; /**
 * Created by sjk on 17-2-7.
 */

import productdemo.utils.DBUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener()
public class InitDBListener implements ServletContextListener {

/*    private String __db = "CREATE DATABASES IF NOT EXISTS `ProductDemo`;" +
            "USE `ProductDemo`;";*/

    private String __category = "CREATE TABLE IF NOT EXISTS `Category` (" +
            "  `cat_id` int(11) NOT NULL AUTO_INCREMENT," +
            "  `cat_name` varchar(100) NOT NULL," +
            "  PRIMARY KEY (`cat_id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

    private String __product = "CREATE TABLE IF NOT EXISTS `Product` (" +
            "  `prod_id` int(11) NOT NULL AUTO_INCREMENT," +
            "  `prod_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," +
            "  `prod_name` varchar(50) NOT NULL," +
            "  `prod_price` decimal(8,2) NOT NULL DEFAULT '0.00'," +
            "  `prod_amount` int(11) NOT NULL DEFAULT '1'," +
            "  `prod_last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
            "  `prod_category` int(11) NOT NULL," +
            "  PRIMARY KEY (`prod_id`)," +
            "  KEY `fk_product_category` (`prod_category`)," +
            "  CONSTRAINT `fk_product_category` FOREIGN KEY (`prod_category`) REFERENCES `Category` (`cat_id`)" +
            ") ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8";

    // Public constructor is required by servlet spec
    public InitDBListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();

            //stmt.addBatch(__db);
            stmt.addBatch(__category);
            stmt.addBatch(__product);

            //stmt.addBatch("INSERT INTO `Category`(`cat_name`) VALUES ('Drink'), ('Thing');");

            stmt.executeBatch();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        System.out.println("OK");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
