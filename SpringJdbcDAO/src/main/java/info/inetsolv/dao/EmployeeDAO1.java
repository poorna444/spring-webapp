package info.inetsolv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import info.inetsolv.entity.Employee;
@Configuration
public class EmployeeDAO1 {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Employee> findAllEmployee(Employee employee){
		String sql="select * from emp_tbl";
	return jdbcTemplate.query(sql,
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
