package info.inetsolv.SpringJdbcDAO;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeService;
import info.inetsolv.util.MOCUtil;

public class RetriveByName {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("name");
	   	String name = scanner.next();
	
    	ApplicationContext container = new AnnotationConfigApplicationContext(MOCUtil.class);
    	
    	EmployeeService service = container.getBean(EmployeeService.class);
    	
    	Employee employee = new Employee();
    	
    	List<Employee> names = service.getAllNames(name);
    	if(names.size()>0) {
    		names.forEach(emp -> {
        		System.out.println(emp.getEno());
        		System.out.println(emp.getName());
        		System.out.println(emp.getSalary());
        	});
    	}
    	else
    	{
    		System.out.println("no records found");
    	}
    	
    	
    	
    	((AbstractApplicationContext) container).close();
      
	}

}
