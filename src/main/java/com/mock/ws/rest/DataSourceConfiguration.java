package com.mock.ws.rest;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:application.properties" })
public class DataSourceConfiguration implements DisposableBean {

	private Environment env;
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Autowired
	public DataSourceConfiguration(Environment env) {
		this.env = env;
		String activeProfiles = String.join(", ", env.getActiveProfiles());
		logger.info("Start creating data source for profile: " + activeProfiles);
	}

	@Bean(name="dataSource")
	@DependsOn(value = "h2Server")
	@Profile(value=ApplicationConfiguration.PROFILE_H2)
	public DataSource getDevDataSource() {
		logger.info("running getDevDataSource() for H2");
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
		logger.info("running getProdDataSource() for Oracle");
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

	@Bean(initMethod = "start", destroyMethod = "stop")
	@DependsOn(value = "h2WebServer")
	public Server h2Server() {
	    try {
	        logger.info("Starting H2 server");
            return Server.createTcpServer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2WebServer() {
        try {
            logger.info("Starting H2 web server");
            return Server.createWebServer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
    public void destroy() throws Exception {
        System.out.println("## Stopping H2 DB Server");
        
    }
}
