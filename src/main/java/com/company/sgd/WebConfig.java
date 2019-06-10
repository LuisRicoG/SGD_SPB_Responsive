package com.company.sgd;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration		
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer  {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/images/**",
                "/css/**",
                "/static/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/images/",
                        "classpath:/css/",
                        "classpath:/static/",
                        "classpath:/js/");	
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
}
