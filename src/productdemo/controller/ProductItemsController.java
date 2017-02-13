package productdemo.controller;

import org.apache.log4j.Logger;
import productdemo.bean.Product;
import productdemo.service.IProductService;
import productdemo.service.impl.ProductServiceImpl;
import productdemo.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by sjk on 17-2-11.
 * <p>
 * 搜索。结果为商品集，所以是"items"
 */
@WebServlet(urlPatterns = "/doItems")
public class ProductItemsController extends HttpServlet {

    private static Logger logger = Logger.getLogger(ProductItemsController.class);
    private IProductService productService = new ProductServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");

    }
}
