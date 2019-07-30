package info.inetsolv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import info.inetsolv.dao.EmployeeByEnoDAO;
import info.inetsolv.entity.Employee;

@Configuration
public class EmployeeByEnoService {
	
	@Autowired
	private EmployeeByEnoDAO employeeByEnoDAO;

	public Employee getRecord(Integer eno) {
		
	return	employeeByEnoDAO.findByEno(eno);
}
}