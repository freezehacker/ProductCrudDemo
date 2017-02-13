package productdemo.listener; /**
 * Created by sjk on 17-2-8.
 */

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.File;

@WebListener()
public class ConfigListener implements ServletContextListener {

    public ConfigListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        // config log4j
        ServletContext context = sce.getServletContext();
        String log4j = context.getInitParameter("log4j_location");
        String fullpath = context.getRealPath("") + File.separator + log4j;
        PropertyConfigurator.configure(fullpath);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing, temporarily.
    }
}
