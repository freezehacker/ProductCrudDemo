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
import java.io.IOException;
import java.util.List;

/**
 * Created by sjk on 17-2-9.
 */
@WebServlet(urlPatterns = "/item")
public class ProductUIController extends HttpServlet {

    private IProductService productService = new ProductServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        if ("INSERT".equals(method)) {
            beforeInsert(request, response);
        } else if ("UPDATE".equals(method)) {
            beforeUpdate(request, response);
        } else if ("SEARCH".equals(method)) {
            beforeSearch(request, response);
        }
    }

    private void beforeSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        //...


        ServletUtils.forward(request, response, "/WEB-INF/pages/front/search_items.jsp");
    }

    private void beforeInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAllCategories();
        request.setAttribute("categoryList", categoryList);

        ServletUtils.forward(request, response, "/WEB-INF/pages/front/insert_item.jsp");
    }

    private void beforeUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Product product = productService.getProductById(id);
        request.setAttribute("product", product);

        List<Category> categoryList = categoryService.getAllCategories();
        request.setAttribute("categoryList", categoryList);

        ServletUtils.forward(request, response, "/WEB-INF/pages/front/update_item.jsp");
    }

}
