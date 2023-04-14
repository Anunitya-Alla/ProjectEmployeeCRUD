package com.anunitya.EmployeeProject.rest;

import com.anunitya.EmployeeProject.Service.EmployeeService;
import com.anunitya.EmployeeProject.dao.EmployeeDAO;
import com.anunitya.EmployeeProject.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty : Inject employee dao(use constructor injection)
    public EmployeeRestController(EmployeeService theemployeeService){
         employeeService = theemployeeService;
    }

    //expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
