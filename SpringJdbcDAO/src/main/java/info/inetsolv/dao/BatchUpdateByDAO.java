package info.inetsolv.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import info.inetsolv.entity.Employee;

@Configuration
public class BatchUpdateByDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveBulkData(ArrayList<Employee> empList) {
		
		String sql="insert into emp_tbl values(?,?,?)";
		
		 jdbcTemplate.batchUpdate(sql, 
				
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						
						Employee employee = empList.get(i);
						ps.setInt(1, employee.getEno());
						ps.setString(2, employee.getName());
						ps.setDouble(3, employee.getSalary());
								
						
					}
					
					@Override
					public int getBatchSize() {
						
						return empList.size();
					}
				}
				
				
				);
	}
}
