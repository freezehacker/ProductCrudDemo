package productdemo.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sjk on 17-2-8.
 */
public class ServletUtils {

    public static void forward(HttpServletRequest req, HttpServletResponse res, String pagePath) throws ServletException, IOException {
        req.getRequestDispatcher(pagePath).forward(req, res);
    }

    public static void redirect(HttpServletRequest req, HttpServletResponse res, String url) throws ServletException, IOException {
        res.sendRedirect(url);
    }
}
