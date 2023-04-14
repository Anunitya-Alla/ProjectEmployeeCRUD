package com.anunitya.EmployeeProject.dao;

import com.anunitya.EmployeeProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
