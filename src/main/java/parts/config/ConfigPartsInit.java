package parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfigPartsInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                ConfigDB.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                ConfigWeb.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
