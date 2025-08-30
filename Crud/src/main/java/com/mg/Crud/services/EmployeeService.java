package com.mg.Crud.services;

import com.mg.Crud.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> showAllEmployee();

    EmployeeEntity showEmployeeByID(Long id);

    void addEmployee(EmployeeEntity employee);

    EmployeeEntity updateEmployee(Long id, EmployeeEntity employee);

    void deleteEmployee(Long id);
}
