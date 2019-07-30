package info.inetsolv.SpringJdbcDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.BatchUpdateByService;
import info.inetsolv.util.MOCUtil;

public class BatchUpdateApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MOCUtil.class);
		
		BatchUpdateByService updateByService = container.getBean(BatchUpdateByService.class);
		
		Employee employee = new Employee(115,"success",999d);
		Employee employee1 = new Employee(116,"success",999d);
		Employee employee2 = new Employee(117,"success",999d);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(employee1);
		list.add(employee2);
		list.add(employee);
	
		updateByService.save(list);
		System.out.println("data inserted");
		
		
		
		
		
	}

}
