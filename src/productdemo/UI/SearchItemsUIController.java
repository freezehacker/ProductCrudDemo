package productdemo.UI;

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
 */
@WebServlet(urlPatterns = "/items")
public class SearchItemsUIController extends HttpServlet {

    private IProductService productService = new ProductServiceImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        if (name == null) {
            ServletUtils.forward(request, response, "/WEB-INF/pages/front/search_items.jsp");
        } else {
            List<Product> products = productService.searchProductsByName(name);
            request.setAttribute("productList", products);
            ServletUtils.forward(request, response, "/WEB-INF/pages/front/search_items.jsp");
        }


    }
}
