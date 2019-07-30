package info.inetsolv.datasource;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource(value="classpath:info/inetsolv/config/database.properties")
public class SimpleDriverDataSourceUtil {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() throws ClassNotFoundException {
		
	
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	
		Class<Driver> source = (Class<Driver>) Class.forName(environment.getProperty("driver"));
		
		dataSource.setDriverClass(source);
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("uname"));
		dataSource.setPassword(environment.getProperty("pasword"));
		
		return dataSource;
		
	}
}
