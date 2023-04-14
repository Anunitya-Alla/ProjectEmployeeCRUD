package com.anunitya.EmployeeProject.Service;

import com.anunitya.EmployeeProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save (Employee theEmployee);

    void deleteId(int theId);
}
