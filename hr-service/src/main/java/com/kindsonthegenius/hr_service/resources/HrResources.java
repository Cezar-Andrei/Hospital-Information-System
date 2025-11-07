package com.kindsonthegenius.hr_service.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kindsonthegenius.hr_service.models.Employee;

@RestController
@RequestMapping("/hr")
public class HrResources {

    List<Employee> employees = Arrays.asList(
        new Employee("E1", "Kindson", "Munonye", "MediTech"),
        new Employee("E2", "Lila", "Hardcastle", "Surgery"),
        new Employee("E3", "Solcae", "Chucks", "Dental")
    );

    @RequestMapping("/employees")
    public List<Employee> getEmployees(){
        return employees;
    }

    @RequestMapping("/employees/{Id}")
    public Employee getEmployeeById(@PathVariable("Id") String Id){
        Employee e = employees.stream()
                .filter(employee -> Id.equals(employee.getId()))
                .findAny()
                .orElse(null);
                
        return e;
    }

}
