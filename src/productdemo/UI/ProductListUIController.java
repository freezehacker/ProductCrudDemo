package productdemo.UI;

import productdemo.bean.Category;
import productdemo.bean.Pager;
import productdemo.bean.Product;
import productdemo.constant.PagerConst;
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

    /**
     * （默认）分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String pageIndex = request.getParameter("pageIndex");
        String pageSize = request.getParameter("pageSize");

        int size, index;

        if (pageSize == null) {
            size = PagerConst.PAGE_SIZE;
        } else {
            size = Integer.valueOf(pageSize);
        }

        if (pageIndex == null) {
            index = PagerConst.PAGE_INDEX;
        } else {
            index = Integer.valueOf(pageIndex);
        }

        Pager<Product> pager = new Pager<>();

        int recordCount = productService.countAllProducts();
        int pageCount = recordCount % size == 0 ? recordCount / size : recordCount / size + 1;
        pager.setPageCount(pageCount);
        pager.setPageIndex(index);
        pager.setPageSize(size);

        pager.setUrl(request.getRequestURL().toString());

        List<Product> products = productService.getProducts(size, index);
        pager.setRecordList(products);



        request.setAttribute("pager", pager);
        ServletUtils.forward(request, response, "/WEB-INF/pages/front/get_list.jsp");
    }
}
