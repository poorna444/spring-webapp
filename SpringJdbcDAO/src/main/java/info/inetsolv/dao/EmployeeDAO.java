package info.inetsolv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import info.inetsolv.entity.Employee;
@Configuration
public class EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int save(Employee employee) {
	
		
	
		String sql="insert into emp_tbl values(?,?,?)";
		int records = jdbcTemplate.update(sql, employee.getEno(),employee.getName(),employee.getSalary());
		
		return records;
		
	}
	
	
//	public List<Employee> findAllEmployee(Employee employee){
//		String sql="select * from emp_tbl";
//		return jdbcTemplate.query(sql,
//				new RowMapper<Employee>() {
//
//					@Override
//					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//						
//						Employee employee = new Employee();
//						employee.setEno(rs.getInt("eno"));
//						employee.setName(rs.getString("ename"));
//						employee.setSalary(rs.getDouble("salary"));
//						
//						return employee;
//					}
//				}
//				
//				
//				
//				);

		
	//}

	
	//this code is retriving record using by eno
//	public Employee findByEno(Integer eno) {
//		
//		String sql="select * from emp_tbl where eno=?";
//		return jdbcTemplate.query(sql, 
//				
//				new PreparedStatementSetter() {
//					
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						ps.setInt(1, eno);
//						
//					}
//				},
//				
//				new ResultSetExtractor<Employee>() {
//
//					@Override
//					public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
//						
//						Employee employee = null;
//						if(rs.next()) {
//							 employee = new Employee();
//							 employee.setEno(rs.getInt("eno"));
//							 employee.setName(rs.getString("ename"));
//							 employee.setSalary(rs.getDouble("salary"));
//						}
//						return employee;
//					}
//					
//					
//				}
//				);
//		
//	}

	
	//THIS IS USING BY NAME
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
