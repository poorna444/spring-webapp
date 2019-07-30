package info.inetsolv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import info.inetsolv.dao.EmployeeByNameDAO;
import info.inetsolv.entity.Employee;

@Configuration
public class EmployeeByNameService {
	@Autowired
	private EmployeeByNameDAO employeeByNameDAO;

	public List<Employee> getAllNames(String name) {
		List<Employee> findByName = employeeByNameDAO.findByName(name);
		return findByName;
		
	}
}
