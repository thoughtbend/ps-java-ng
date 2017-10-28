package com.thoughtbend.wiredcoffee.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomerManagementAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
	
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(CustomerManagementAppConfig.class);
		appContext.refresh();
		
		DispatcherServlet servlet = new DispatcherServlet(appContext);
		
		ServletRegistration.Dynamic registration = context.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
	    registration.addMapping("/app/*");
	}

}
