package parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CfgPartsInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() { // доступ к базе, сущности
        return new Class<?>[]{
                CfgDataBase.class
        };
    }

    protected Class<?>[] getServletConfigClasses() { // мапинг к jsp/view
        return new Class<?>[]{
                CfgMvcDispatcherServlet.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
