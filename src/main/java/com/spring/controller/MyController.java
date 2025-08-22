package com.spring.controller;

import com.spring.entity.Employee;
import com.spring.repo.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {

    @GetMapping("/getName")
    public ResponseEntity<List<String>> getName(){
        List<String> nameList = Arrays.asList("shailaja","kajal","mrunal","riya");
        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }

    //metod to get names that starts with 'A' or 'S'
    @GetMapping("/nameListA")
    public ResponseEntity<List<String>> getNameList(){
        List<String> namelist = Arrays.asList("kajal","Ajay","Amar","om","shailaja","Aditya");
        List<String> listA = namelist.stream().filter(a -> a.startsWith("A")).collect(Collectors.toList());
        return new ResponseEntity<>(listA, HttpStatus.OK);
    }
//
    //Convert all string names into uppercase
    @GetMapping("/nameinUppercase")
    public ResponseEntity<List<String>> getList() {
        List<String> namelist = Arrays.asList("kajal", "Ajay", "Amar", "om", "shailaja", "Aditya");
        List<String> list1 = namelist.stream().map(String::toUpperCase).toList();
        return new ResponseEntity<>(list1, HttpStatus.OK);
    }

    //create list of integer and retrive even number from it
    @GetMapping("/evenList")
    public ResponseEntity<List<Integer>> numList(){
        List<Integer> nums = Arrays.asList(1,23,345,8376,274,98,12,334,45,48);
        List<Integer> even = nums.stream().filter(a-> a%2==0).toList();
        return new ResponseEntity<>(even , HttpStatus.OK);
    }

//    //return square of each number in list
//    @GetMapping("/squareList")
//    public ResponseEntity<List<Integer>> squarenum(){
//        List<Integer> nums = Arrays.asList(1,23,345,8376,274,98,12,334,45,48);
//        List<Integer> squareList = nums.stream().map(a-> a*a).toList();
//        return new ResponseEntity<>(squareList, HttpStatus.OK);
//    }

    //Using employee obj
    @GetMapping("/getEmpName")
    public ResponseEntity<Employee> getEmp(){
        Employee e = new Employee();
        e.setId(101);
        e.setFname("shailaja");
        e.setLname("kshirsagar");
        e.setCity("pune");
        return  new ResponseEntity<>(e, HttpStatus.OK);
    }

    //get all emp data
    @GetMapping("/getAllEmpData")
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> employeeList = EmployeeRepo.getAllEmp();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    //get DAta by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getDataById(@PathVariable("id") int id){
        List<Employee> employeeList = EmployeeRepo.getAllEmp();
        for(Employee e : employeeList){
            if(id == e.getId()){
                return new ResponseEntity<>(e, HttpStatus.OK);
            }
        }
        Employee e1 = new Employee();
        return new ResponseEntity<>(e1,HttpStatus.NOT_FOUND);
    }

    //get data by city
    @GetMapping("/getDataByCity/{city}")
    public ResponseEntity<List<Employee>> getDataByCity(@PathVariable("city") String city){
        List<Employee> employeeList = EmployeeRepo.getAllEmp();
        List<Employee> empCityWise = new ArrayList<>();
        for(Employee e : employeeList){
            if(e.getCity().equalsIgnoreCase(city)){
                empCityWise.add(e);
            }
        }
        return new ResponseEntity<>(empCityWise, HttpStatus.OK);
    }

    //getbycity
    @GetMapping("/sorted")
    public ResponseEntity<List<Employee>> getAllemp(@RequestParam(required = false) String city){
        System.err.println("City value is : "+city);
        List<Employee> employeeList = EmployeeRepo.getAllEmp();
        if(city!=null){
            //sort by city
            List<Employee> empCityWise = new ArrayList<>();
            for(Employee e : employeeList){
                if(e.getCity().equalsIgnoreCase(city)){
                    empCityWise.add(e);
                }
            }
            return new ResponseEntity<>(empCityWise, HttpStatus.OK);
        }
        else {
            //return all data
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    //add employee , get data from postman
    @PostMapping("/addEmp")
    public ResponseEntity<String> addEmp(@RequestBody Employee e){
        System.err.println("Employee object " + e);
        return new ResponseEntity<>("Data saved successfully", HttpStatus.CREATED);
    }

    //add  multiple employee in request body
    @PostMapping("/addEmpList")
    public ResponseEntity<String> addMulEmp(@RequestBody List<Employee> e){
        System.err.println("Employee : " + e);
        return new ResponseEntity<String>("Employee added",HttpStatus.CREATED);
    }
}
