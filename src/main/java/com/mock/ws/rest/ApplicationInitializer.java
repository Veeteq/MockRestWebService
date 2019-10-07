package com.mock.ws.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

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
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		//servletContext.setInitParameter("spring.profiles.active", "oracle");

		if (servletContext.getInitParameter("spring.profiles.active") == ApplicationConfiguration.PROFILE_H2) {
			ServletRegistration.Dynamic h2Servlet = servletContext.addServlet("h2-console", new WebServlet());
			h2Servlet.setLoadOnStartup(2);
			h2Servlet.addMapping("/console/");
		}
	}
}