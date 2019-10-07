package com.mock.ws.rest;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:application.properties" })
public class DataSourceConfiguration {

	private Environment env;

	@Autowired
	public DataSourceConfiguration(Environment env) {
		this.env = env;
		String activeProfiles = String.join(", ", env.getActiveProfiles());
		System.out.println(activeProfiles);
	}

	@Bean(name="dataSource")
	@Profile(value=ApplicationConfiguration.PROFILE_H2)
	public DataSource getDevDataSource() {
		System.out.println("running getDevDataSource() for H2");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.h2.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.h2.url"));
		dataSource.setUsername(env.getProperty("jdbc.h2.username"));
		dataSource.setPassword(env.getProperty("jdbc.h2.password"));
		return dataSource;
	}

	@Bean(name="dataSource")
	@Profile(value=ApplicationConfiguration.PROFILE_ORACLE)
	public DataSource getProdDataSource() {
		System.out.println("running getProdDataSource() for Oracle");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.oracle.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.oracle.url"));
		dataSource.setUsername(env.getProperty("jdbc.oracle.username"));
		dataSource.setPassword(env.getProperty("jdbc.oracle.password"));
		return dataSource;
	}
	
	@Bean(name="hibernateProperties")
	@Profile(value=ApplicationConfiguration.PROFILE_H2)
	public Properties getDevHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.h2.dialect"));
		properties.setProperty("hibernate.globally_quoted_identifiers", "true");
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.default_schema", env.getProperty("hibernate.h2.default_schema"));
		return properties;
	}
	
	@Bean(name="hibernateProperties")
	@Profile(value=ApplicationConfiguration.PROFILE_ORACLE)
	public Properties getProdHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.oracle.dialect"));
		properties.setProperty("hibernate.globally_quoted_identifiers", "true");
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
	}
}
