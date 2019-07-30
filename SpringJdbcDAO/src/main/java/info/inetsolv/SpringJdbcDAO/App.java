package info.inetsolv.SpringJdbcDAO;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeService;
import info.inetsolv.util.MOCUtil;

public class App 
{
    public static void main( String[] args ){
    	
    	
 	Scanner scanner = new Scanner(System.in);
   	
//    	System.out.println("enter eno");
//    	
//    	int eno = scanner.nextInt();
//    	
  	System.out.println("name");
   	String name = scanner.next();
//    	
//    	System.out.println("salary");
//    	double salary = scanner.nextDouble();
//    	
  	Employee employee = new Employee();
//    	
//    	employee.setEno(eno);
//    	employee.setName(name);
//    	employee.setSalary(salary);
//    	
    	ApplicationContext container = new AnnotationConfigApplicationContext(MOCUtil.class);
    	
    	EmployeeService service = container.getBean(EmployeeService.class);
    	
    
    	
//    	int calTax = service.calTax(employee);
//    	
//    	System.out.println(calTax);
//    	System.out.println("data inserted");
    	
    	
    	// this is  code of retrieving all records
//    	List<Employee> list = service.getData(employee);
//    	
//    	list.forEach(emp -> {
//    		System.out.println(emp.getEno());
//    		System.out.println(emp.getName());
//    		System.out.println(emp.getSalary());
//    	});
    	
    	
    	// this is retriving record by eno3
//    	
//    	Employee record = service.getRecord(eno);
//    	
//    	if(null != record) {
//    		
//        	System.out.println(record.getEno());
//        	System.out.println(record.getName());
//        	System.out.println(record.getSalary());
//    		
//    	}else {
//    		System.out.println("no records found");
//    	}
    		//THIS IS RETRIVING BY NAME
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
