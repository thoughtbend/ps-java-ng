package com.thoughtbend.wiredcoffee.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@EnableWebMvc
//@ComponentScan("com.thoughtbend.wiredcoffee.web.controller")
@ComponentScan({"com.thoughtbend.wiredcoffee.web.controller", "com.thoughtbend.wiredcoffee.service"})
public class CustomerManagementAppConfig /*implements WebMvcConfigurer*/ {

	/*@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(this.viewResolver());
		//WebMvcConfigurer.super.configureViewResolvers(registry);
	}*/

	@Bean
	public ViewResolver viewResolver() {
		
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
