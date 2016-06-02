package main.groovy.application;

import main.groovy.application.configurations.WebMVCConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by User on 2.06.2016.
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[] {WebMVCConfigurer.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return null;
    }

    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }

}
