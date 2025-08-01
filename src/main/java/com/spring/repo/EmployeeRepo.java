package com.spring.repo;

import com.spring.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepo {

    public static List<Employee> getAllEmp(){
        Employee e = new Employee(101,"shailaja","kshirsagar","pune");
        Employee e1 = new Employee(102,"kajal","jagtap","pune");
        Employee e2 = new Employee(103,"om","chavan","solapur");
        Employee e3 = new Employee(104,"riya","sawwalakhe","amravati");
        Employee e4 = new Employee(105,"shivani","wange","amravati");
        Employee e5 = new Employee(106,"raghav","khandelwal","pune");
        Employee e6 = new Employee(107,"devidas","dhongade","nashik");
        Employee e7 = new Employee(108,"mrunal","amrutkar","nashik");
        Employee e8 = new Employee(109,"shravani","madane","pune");
        Employee e9 = new Employee(110,"srushti","kamlajkar","sambhajinagar");

        List<Employee> emplist = Arrays.asList(e,e1,e2,e3,e4,e5,e6,e7,e8,e9);
        return emplist;

    }
}
