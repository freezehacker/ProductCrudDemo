package productdemo.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by sjk on 17-2-9.
 */
public class MyBeanUtils {

    /**
     * 将请求参数转化成一个bean
     * 注意，这里参数名要与bean中定义的字段名相等
     *
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
        try {
            Enumeration<String> keys = request.getParameterNames();
            T bean = clazz.newInstance();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                String value = request.getParameter(key);
                BeanUtils.setProperty(bean, key, value);
            }
            return bean;
        } catch (Exception e) {
            return null;
        }
    }
}
