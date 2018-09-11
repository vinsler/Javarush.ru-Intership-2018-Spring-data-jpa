package parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CfgWebDispatcherInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() { // мапинг ко всему кроме web
        return new Class<?>[]{
                CfgDataBase.class, CfgServiceInit.class
        };
    }

    protected Class<?>[] getServletConfigClasses() { // мапинг к web
        return new Class<?>[]{
                CfgMvcViewResource.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
