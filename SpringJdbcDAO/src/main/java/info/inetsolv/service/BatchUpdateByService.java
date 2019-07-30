package info.inetsolv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import info.inetsolv.dao.BatchUpdateByDAO;
import info.inetsolv.entity.Employee;

@Configuration
public class BatchUpdateByService {

	@Autowired
	private BatchUpdateByDAO batchUpdateByDAO;
	
//	public List<Employee> save(ArrayList<Employee> employee ) {
//		
//		
//		batchUpdateByDAO.saveBulkData(employee);
//		return employee;
//		
//		
//		
//		
//	}

	public List<Employee> save(ArrayList<Employee> employee) {
		
		batchUpdateByDAO.saveBulkData(employee);
		return employee;
	}
}
