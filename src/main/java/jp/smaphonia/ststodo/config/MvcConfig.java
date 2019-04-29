package jp.smaphonia.ststodo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.smaphonia.ststodo.filter.MDCLoggingFilter;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
	
	@Bean
	public FilterRegistrationBean<MDCLoggingFilter> mbcLogginFilter() {
		FilterRegistrationBean<MDCLoggingFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new MDCLoggingFilter());
		bean.setOrder(1);
		return bean;
	}

}
