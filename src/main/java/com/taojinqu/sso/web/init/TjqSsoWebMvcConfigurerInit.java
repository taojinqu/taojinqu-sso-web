package com.taojinqu.sso.web.init;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.taojinqu.sso.web.common.TjqSsoWebConstants;

@Configuration
@EnableWebMvc
public class TjqSsoWebMvcConfigurerInit extends WebMvcConfigurerAdapter {

	/**
	 * 映射静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/base/fonts/**")
				.addResourceLocations("classpath:/static/bi/resources/base/fonts/");
		super.addResourceHandlers(registry);
	}

	/**
	 * Rest接口返回用UTF-8编码
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		StringHttpMessageConverter msgConverter = new StringHttpMessageConverter(TjqSsoWebConstants.UTF8);
		converters.add(msgConverter);
	}
}
