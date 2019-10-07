package com.mock.ws.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.mock.ws.rest")
@EnableWebMvc
public class ApplicationConfiguration {
	public static final String PROFILE_H2 = "h2";
	public static final String PROFILE_ORCLE = "oracle";

}
