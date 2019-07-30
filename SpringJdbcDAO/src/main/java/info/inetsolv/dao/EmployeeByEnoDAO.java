package info.inetsolv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import info.inetsolv.entity.Employee;

@Configuration
public class EmployeeByEnoDAO {

	@Autowired
	 private JdbcTemplate jdbcTemplate;


	public Employee findByEno(Integer eno) {
		
		String sql="select * from emp_tbl where eno=?";
	return jdbcTemplate.query(sql, 
				
				new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, eno);
						
					}
				},
				
				new ResultSetExtractor<Employee>() {

					@Override
					public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
						
						Employee employee = null;
						if(rs.next()) {
							 employee = new Employee();
							 employee.setEno(rs.getInt("eno"));
							 employee.setName(rs.getString("ename"));
							 employee.setSalary(rs.getDouble("salary"));
						}
						return employee;
					}
					
					
				}
				);
		
	}

}


