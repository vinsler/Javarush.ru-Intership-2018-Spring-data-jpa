package parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CfgPartsInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                CfgDataBase.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                CfgMvcDispatcherServlet.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
