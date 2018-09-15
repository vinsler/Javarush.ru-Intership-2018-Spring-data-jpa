package parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{DataBaseConfig.class, ServiceConfig.class};
    }

    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{MvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
