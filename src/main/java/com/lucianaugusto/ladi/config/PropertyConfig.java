package com.lucianaugusto.ladi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.lucianaugusto.ladi.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties") // Specifies that it should use the set of properties inside the
// datasource.properties file
public class PropertyConfig {

	@Autowired
	Environment env;
	//	Properties
	@Value("${com.username}")
	String user;
	
	@Value("${com.password}")
	String password;
	
	@Value("${com.dburl}")
	String url;
	
//	Returning a bean for the properties
	@Bean
	public FakeDataSource fakeDataSource() { // Sets up the properties on the fakeDataSource. Asks the @Configuration to use
		// a Spring expression language statement to get that value from the externalised properties
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(env.getProperty("USERNAME"));
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	
	@Bean // Adding a new bean for the PropertySourcesPlaceholderConfigurer
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}

}
