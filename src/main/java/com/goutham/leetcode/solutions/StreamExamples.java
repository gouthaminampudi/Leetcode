package com.goutham.leetcode.solutions;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.goutham.leetcode.utilities.Inventory;
import com.goutham.leetcode.utilities.PopulateInventory;



public class StreamExamples {
	

	public static void main(String[] args) {
		
		try {
			List<Inventory>inventorys =PopulateInventory.populateInventory();
			//getByDepartmentSortedByName(inventorys);
			getHighestStock(inventorys);
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

}
