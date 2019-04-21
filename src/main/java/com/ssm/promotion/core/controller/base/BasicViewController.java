package com.ssm.promotion.core.controller.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
 * 
 * @author  liu66
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ssm.promotion.core.controller")
public class BasicViewController extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/jsonp/index").setViewName("jsonp/index");
	}
	
}
