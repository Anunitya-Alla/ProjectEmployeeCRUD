package com.anunitya.EmployeeProject.rest;

import com.anunitya.EmployeeProject.Service.EmployeeService;
import com.anunitya.EmployeeProject.dao.EmployeeDAO;
import com.anunitya.EmployeeProject.entity.Employee;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
         Employee employee =  employeeService.findById(employeeId);
         if (employee == null){
             throw new RuntimeException("Employee Id is not found");
         }
         return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //To save a new item, the id has to be 0. If in case they pass id in JSON we set it to 0 to force a save of new item
        theEmployee.setId(0);
        //Add the employee to DB
        Employee dbEmployee = employeeService.save(theEmployee);
        //return the employee from the DB with the updated ID
        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        //save the new employee details in db
        Employee dbEmployee = employeeService.save(theEmployee);
        //return db employee
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        //If employee is not present in DB throw an exception
        if (tempEmployee == null){
            throw new RuntimeException("Employee ID is not found "+employeeId);
        }

        employeeService.deleteId(employeeId);
        return "Deleted employee id - "+employeeId;

    }


}
