package productdemo.UI;

import productdemo.bean.Category;
import productdemo.bean.Product;
import productdemo.service.ICategoryService;
import productdemo.service.IProductService;
import productdemo.service.impl.CategoryServiceImpl;
import productdemo.service.impl.ProductServiceImpl;
import productdemo.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjk on 17-2-8.
 */
@WebServlet(urlPatterns = "/list")
public class ProductListUIController extends HttpServlet {

    private IProductService productService = new ProductServiceImpl();
    //private ICategoryService categoryService = new CategoryServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 商品列表
        List<Product> productList = productService.getAllProducts();
        request.setAttribute("productList", productList);

        ServletUtils.forward(request, response, "/WEB-INF/pages/front/get_list.jsp");
    }
}
