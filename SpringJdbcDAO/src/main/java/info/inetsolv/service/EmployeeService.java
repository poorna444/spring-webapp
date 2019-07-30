package info.inetsolv.service;

import info.inetsolv.dao.EmployeeDAO;
import info.inetsolv.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	public int calTax(Employee employee) {
		Double salary = employee.getSalary();
		
		Double tax = salary*.3;
		
		Double netsalary=salary-tax;
		
		employee.setSalary(netsalary);
		
		int save = employeeDAO.save(employee);
		
		return save;
		
}
	
	//this all records
//public List<Employee> getData(Employee employee){
//  return	employeeDAO.findAllEmployee(employee);
	

	
	
//}
	
	
	//this is by eno
//	public Employee getRecord(Integer eno) {
//		
//	return	employeeDAO.findByEno(eno);
//		
		
//	}
	//THIS IS BY NAME
	public List<Employee> getAllNames(String name) {
		List<Employee> findByName = employeeDAO.findByName(name);
		return findByName;
		
	}
	
}
