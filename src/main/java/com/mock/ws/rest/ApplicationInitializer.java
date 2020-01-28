package com.mock.ws.rest;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/rest/*" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        
        //if (initParameter == ApplicationConfiguration.PROFILE_H2) {
            logger.info( "Initializing H2 console" );
            ServletRegistration.Dynamic h2Servlet = servletContext.addServlet("h2-console", new WebServlet());
            h2Servlet.setLoadOnStartup(2);
            h2Servlet.addMapping("/console/*");
        //}
    }
}
