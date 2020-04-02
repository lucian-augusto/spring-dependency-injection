package com.lucianaugusto.ladi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.lucianaugusto.ladi.examplebeans.FakeDataSource;
import com.lucianaugusto.ladi.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"}) // Specifies that it should use the set of properties inside the
//// datasource.properties file. It is possible to pass a list of property files to the @PropertySource Annotation
@PropertySources({ // More recent (introduced in Spring 4) way of setting up multiple configuration property sources
	// Provides a cleaner and better way to visualize all the property sources.
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

//	FakeDataSource Fields
	@Autowired
	Environment env;
	@Value("${com.username}")
	String user;
	
	@Value("${com.password}")
	String password;
	
	@Value("${com.dburl}")
	String url;
	
//	JMS Fields
	@Value("${com.jms.username}")
	String jmsUsername;
	
	@Value("${com.jms.password}")
	String jmsPassword;
	
	@Value("${com.jms.url}")
	String jmsUrl;
	
//	Returning a bean for the fake data source properties
	@Bean
	public FakeDataSource fakeDataSource() { // Sets up the properties on the fakeDataSource. Asks the @Configuration to use
		// a Spring expression language statement to get that value from the externalised properties
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(env.getProperty("USERNAME"));
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
//	Returning a bean for the fake jms properties
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUsername(jmsUsername);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setUrl(jmsUrl);
		return fakeJmsBroker;
	}
	
	
	@Bean // Adding a new bean for the PropertySourcesPlaceholderConfigurer
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}

}
