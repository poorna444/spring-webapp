package info.inetsolv.datasource;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource(value="classpath:info/inetsolv/config/database.properties")
public class C3P0ConnectionPoolUtil {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass(environment.getProperty("driver"));
		dataSource.setJdbcUrl(environment.getProperty("url"));
		dataSource.setUser(environment.getProperty("uname"));
		dataSource.setPassword(environment.getProperty("pasword"));
		
		
		
		return dataSource;
		
		
	}

}
