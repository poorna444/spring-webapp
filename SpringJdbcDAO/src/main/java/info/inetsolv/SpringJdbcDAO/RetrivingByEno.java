package info.inetsolv.SpringJdbcDAO;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeByEnoService;
import info.inetsolv.util.MOCUtil;

public class RetrivingByEno {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	   	
    	System.out.println("enter eno");
    	
    	int eno = scanner.nextInt();
		Employee employee = new Employee();
		
ApplicationContext container = new AnnotationConfigApplicationContext(MOCUtil.class);



    	
    	EmployeeByEnoService service = container.getBean(EmployeeByEnoService.class);
    	
    	
    	Employee record = service.getRecord(eno);
   	
    	if(null != record) {
    		
       	System.out.println(record.getEno());
        	System.out.println(record.getName());
        	System.out.println(record.getSalary());
    		
    	}else {
    		System.out.println("no records found");
    	}

	}

}
