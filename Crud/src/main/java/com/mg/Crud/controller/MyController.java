package com.mg.Crud.controller;

import com.mg.Crud.Entity.EmployeeEntity;
import com.mg.Crud.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MyController {

    private final EmployeeService service;

    public MyController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return service.showAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return service.showEmployeeByID(id);
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeEntity emp) {
        service.addEmployee(emp);
        return "Employee Added successfully";
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity empDetails) {
        return service.updateEmployee(id, empDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
