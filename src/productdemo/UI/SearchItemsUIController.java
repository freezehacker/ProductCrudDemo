package productdemo.UI;

import productdemo.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sjk on 17-2-11.
 */
@WebServlet(name = "SearchItemsUIController", urlPatterns = "/items")
public class SearchItemsUIController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.forward(request, response, "/WEB-INF/pages/front/search_items.jsp");
    }
}
