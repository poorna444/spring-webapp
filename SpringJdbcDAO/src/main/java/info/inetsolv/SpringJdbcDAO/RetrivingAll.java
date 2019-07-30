package info.inetsolv.SpringJdbcDAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeService1;
import info.inetsolv.util.MOCUtil;

public class RetrivingAll {

	public static void main(String[] args) {
	
ApplicationContext container = new AnnotationConfigApplicationContext(MOCUtil.class);
    	
    	EmployeeService1 service = container.getBean(EmployeeService1.class);
    	
    	Employee employee = new Employee();
    	List<Employee> list = service.getData(employee);
    	
   	list.forEach(emp -> {
    		System.out.println(emp.getEno());
    		System.out.println(emp.getName());
    		System.out.println(emp.getSalary());
    	});
    	
    	((AbstractApplicationContext) container).close();
    	

	}

}
