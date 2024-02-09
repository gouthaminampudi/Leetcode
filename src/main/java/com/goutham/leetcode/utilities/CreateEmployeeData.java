package com.goutham.leetcode.utilities;

import java.util.ArrayList;
import java.util.List;

public class CreateEmployeeData {
    
    public static List<Employee> getEmployeeList(){

        List<Employee> empList = new ArrayList<>();
        empList.add(createEmployee("Robert", 1, 1, null,100000));
        empList.add(createEmployee("John", 2, 2, "disabled",110000));
        empList.add(createEmployee("Joseph", 3, 3, null,125000));
        empList.add(createEmployee("Goutham", 4, 1, null,136500));
        empList.add(createEmployee("Jordan", 5, 2, null,168740));
        empList.add(createEmployee("Claire", 6, 3, "disabled",95000));
        empList.add(createEmployee("Mary", 7, 1, null,56054));
        empList.add(createEmployee("Melissa", 8, 2, null,235000));
        empList.add(createEmployee("Miaay", 9, 3, "disabled",124000));
        empList.add(createEmployee("Smith", 10, 1, null,147147));
        empList.add(createEmployee("Steve", 11, 2, null,159159));
        empList.add(createEmployee("Arnav", 12, 3, null,168741));
        empList.add(createEmployee("Vivan", 13, 1, null,132546));
        empList.add(createEmployee("Sireesha", 14, 2, null,69222));
        empList.add(createEmployee("Kevin", 15, 3, null,31254));
        return empList;
        
    }

    private static Employee createEmployee(String name, int empId, int deptId, String status,int salary){
        Employee emp = new Employee(empId,name,deptId,salary);
        if(!"active".equalsIgnoreCase(status)&&status!=null){
            emp.setStatus(status);
        }
        return emp;
    }

}
