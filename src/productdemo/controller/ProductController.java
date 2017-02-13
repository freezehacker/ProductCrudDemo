package productdemo.controller;

import org.apache.log4j.Logger;
import productdemo.bean.Product;
import productdemo.service.IProductService;
import productdemo.service.impl.ProductServiceImpl;
import productdemo.utils.MyBeanUtils;
import productdemo.utils.ServletUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sjk on 17-2-9.
 * URL LIKE "/doItem?method=GET&&id=10001"
 */
@WebServlet(urlPatterns = "/doItem")
public class ProductController extends HttpServlet {

    private IProductService productService = new ProductServiceImpl();
    private static Logger logger = Logger.getLogger(ProductController.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 与客户端保持一致，都使用UTF-8编码解码
        req.setCharacterEncoding("utf-8");

        String method = req.getParameter("method");

        // 分发给不同的函数去处理
        if ("INSERT".equals(method)) {
            processInsert(req, res);
        } else if ("DELETE".equals(method)) {
            processDelete(req, res);
        } else if ("UPDATE".equals(method)) {
            processUpdate(req, res);
        }
    }

    // 新增一个商品
    private void processInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = Product.fromRequest(req);
        //Product product = MyBeanUtils.request2Bean(req, Product.class);
        productService.addProduct(product);

        ServletUtils.redirect(req, res, "/list");
    }

    // 删除一个商品
    private void processDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        productService.removeProductById(id);

        ServletUtils.redirect(req, res, "/list");
    }

    // 修改商品的信息
    private void processUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Product product = MyBeanUtils.request2Bean(req, Product.class);
        Product product = Product.fromRequest(req);
        productService.modifyProduct(product);

        ServletUtils.redirect(req, res, "/list");
    }

}
