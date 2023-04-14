package com.anunitya.EmployeeProject.dao;

import com.anunitya.EmployeeProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.type.descriptor.java.SerializableJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //set up construction injector with Autowired
    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);

        //execute query and get results
        List<Employee> employees = theQuery.getResultList();

        //return results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save employee
        Employee dbEmployee  = entityManager.merge(theEmployee);

        //return employee
        return dbEmployee;
    }

    @Override
    public void deleteId(int theId) {

        //find employee by Id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //remove employee
        entityManager.remove(theEmployee);


    }
}
