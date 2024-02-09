package com.goutham.leetcode.utilities;

public class Employee {
    
    private int empId;
    private String empName;
    private int deptId;
    private String status ="active";
    private int salary;

    public Employee(int empId,String empName,int deptId,int salary){
        super();
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.salary = salary;
    }

    public int getEmpId(){
        return this.empId;
    }

    public String getEmpName(){
        return this.empName;
    }

    public int getDeptId(){
        return this.deptId;
    }

    public int getSalary(){
        return this.salary;
    }

    public String getStatus(){
        return this.status;
    }


    public void setEmpId(int empId){
        this.empId = empId;
    }

    public void setEmpName(String empName){
        this.empName = empName;
    }

    public void setDeptId(int deptId){
        this.deptId = deptId;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String toString(){
        return "Name: " + this.getEmpName()
                +", Emp Id: "+ this.getEmpId()
                +", Dept Id: "+ this.getDeptId()
                +", Salary: "+ this.getSalary()
                +", Status: "+ this.getStatus();
    }
}
