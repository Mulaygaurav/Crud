package com.mg.Crud.services;

import com.mg.Crud.Entity.EmployeeEntity;
import com.mg.Crud.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeServiceImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<EmployeeEntity> showAllEmployee() {
        return repo.findAll();
    }

    @Override
    public EmployeeEntity showEmployeeByID(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
    }

    @Override
    public void addEmployee(EmployeeEntity employee) {
        repo.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        EmployeeEntity emp = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));

        emp.setName(employeeDetails.getName());
        emp.setEmail(employeeDetails.getEmail());
        emp.setActive(employeeDetails.isActive());

        return repo.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeEntity emp = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id: " + id));
        repo.delete(emp);
    }
}
