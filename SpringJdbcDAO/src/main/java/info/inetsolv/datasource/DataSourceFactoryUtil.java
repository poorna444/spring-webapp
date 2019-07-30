package info.inetsolv.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
//@PropertySource(value="classpath:info/inetsolv/config/mysql.properties")
@PropertySource(value="classpath:info/inetsolv/config/database.properties")
public class DataSourceFactoryUtil {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("uname"));
		dataSource.setPassword(environment.getProperty("pasword"));
		
		return dataSource;
		
	}

}
