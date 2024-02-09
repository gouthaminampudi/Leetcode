package com.goutham.tutorials;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.goutham.leetcode.utilities.CreateEmployeeData;
import com.goutham.leetcode.utilities.Employee;
import com.goutham.leetcode.utilities.Inventory;
import com.goutham.leetcode.utilities.PopulateInventory;



public class StreamExamples {
	

	public static void main(String[] args) {
		
		try {
			List<Inventory>inventorys =PopulateInventory.populateInventory();
			//getByDepartmentSortedByName(inventorys);
			//getHighestStock(inventorys);
	       // employeeDetailByEachDept();
			employeeCountByEachDept();
			employeeDetailByStatus();
			employeeMaxAndMinSalary();
			employeeMaxByEachDept();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void forEachMethod(List<Inventory>inventorys) throws IOException {
		
		inventorys.stream()
		.forEach(System.out::println);
	}
	
	//filter is to filter out values based on a condition, so we pick some and leave some
	private static void filterMethod(List<Inventory>inventorys) throws IOException {

		inventorys.stream()
		.filter(i -> i.getDepartment().equalsIgnoreCase("diary"))
		.forEach(System.out::println);
	}
	
	//map is to transform from one type to another, here we are tronsforming from a Inventory object to String
	private static void mapMethod(List<Inventory>inventorys) throws IOException {

		String [] filters = { "diary" };
		
		  List<List<Inventory>> employees = Stream.of(filters)
			      .map(PopulateInventory::getByDepartment)
			      .collect(Collectors.toList());
		  
		  List<Inventory> namesFlatStream = employees.stream()
			      .flatMap(Collection::stream)
			      .collect(Collectors.toList());
		  namesFlatStream.stream()
		  .forEach(System.out::println);
		  
	}
	
	private static void getByDepartmentSortedByName(List<Inventory>inventorys) throws IOException {

		String [] filters = { "diary" };
		
		List<Inventory> namesFlatStream  =Stream.of(filters)
			      .map(PopulateInventory::getByDepartment)
			      .flatMap(Collection::stream)
					.sorted(Comparator.comparing(Inventory::getName))
					.peek(System.out::println)
			      .collect(Collectors.toList());
		  ;

		  
		  
		  
	}
	
	private static void getHighestStock(List<Inventory>inventorys) throws IOException {

		String [] filters = { "diary" };
		
		Optional<Inventory> highest  =inventorys.stream()
				.max(Comparator.comparing(Inventory::getStock));
				//	.peek(System.out::println)
				//	.reduce( (c1, c2)
			      //          -> c1.getStock() > c2.getStock() ? c1 : c2);
		  

		  
		highest.ifPresent(System.out::println);
		  
	}


//1.Write a program to print employee details working in each department

	private static void employeeDetailByEachDept(){
		List<Employee> empList = CreateEmployeeData.getEmployeeList();
		empList.stream().collect(Collectors.groupingBy(e->e.getDeptId())).entrySet().forEach((e)->{
			System.out.println(e.getKey()+"--"+e.getValue());
		});
		
	}

//2.Write a program to print employees count working in each department
private static void employeeCountByEachDept(){
	List<Employee> empList = CreateEmployeeData.getEmployeeList();
	empList.stream().collect(Collectors.groupingBy(e->e.getDeptId(),Collectors.counting())).entrySet().forEach((e)->{
		System.out.println(e.getKey()+"--"+e.getValue());
	});;
	
}

//3.Write a program to print active and inactive employees in the given collection

private static void employeeDetailByStatus(){
	List<Employee> empList = CreateEmployeeData.getEmployeeList();
	empList.stream().collect(Collectors.groupingBy(e->e.getStatus())).entrySet().forEach((e)->{
		System.out.println(e.getKey()+"--"+e.getValue());
	});
	
}


//4.Write a program to print Max/Min employee salary from the given collection

private static void employeeMaxAndMinSalary(){
	
	List<Employee> empList = CreateEmployeeData.getEmployeeList();
	int maxSalary = empList.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
	System.out.println(maxSalary);

	int minSalary = empList.stream().min(Comparator.comparing(Employee::getSalary)).get().getSalary();

	System.out.println(minSalary);
}

//5.Write a program to print the max salary of an employee from each department
	private static void employeeMaxByEachDept(){
		List<Employee> empList = CreateEmployeeData.getEmployeeList();
		Map<Integer, Integer > emps =empList.
		stream().
		collect(
			Collectors.groupingBy(
				e->e.getDeptId(),
				Collectors.collectingAndThen(
					Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
					 optionalEmp->optionalEmp.map(Employee::getSalary).orElse(0))));

		System.out.println(emps);		

		  List<String> employeeDetails = empList.stream()
            .flatMap(emp -> Arrays.stream(new String[] {
                "ID: " + emp.getEmpId(),
                "Name: " + emp.getEmpName(),
                "Department: " + emp.getDeptId(),
                "Status: " + emp.getStatus(),
                "Salary: " + emp.getSalary()
            }))
            .collect(Collectors.toList());

        System.out.println(employeeDetails);
	}
}
