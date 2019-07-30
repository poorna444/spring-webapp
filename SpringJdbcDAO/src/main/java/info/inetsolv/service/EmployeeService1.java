package info.inetsolv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import info.inetsolv.dao.EmployeeDAO1;
import info.inetsolv.entity.Employee;

@Configuration
public class EmployeeService1 {
	@Autowired
	private EmployeeDAO1 employeeDAO1;
	
	public List<Employee> getData(Employee employee){
	  return	employeeDAO1.findAllEmployee(employee);

}
}