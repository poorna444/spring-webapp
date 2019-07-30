package info.inetsolv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import info.inetsolv.entity.Employee;

@Configuration
public class EmployeeByNameDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> findByName(String name) {
		
		return	jdbcTemplate.query(
					
					new PreparedStatementCreator() {
						
						@Override
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement prepareStatement = con.prepareStatement("select * from emp_tbl where lower(ename) = lower(?)");
							prepareStatement.setString(1, name);
							return prepareStatement;
						}
					}, 
					
					
					new RowMapper<Employee>() {

						@Override
						public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							Employee employee = new Employee();
							employee.setEno(rs.getInt("eno"));
							employee.setName(rs.getString("ename"));
							employee.setSalary(rs.getDouble("salary"));
							return employee;
						}
						
					}
					
					);
			
			
		}
	
}
