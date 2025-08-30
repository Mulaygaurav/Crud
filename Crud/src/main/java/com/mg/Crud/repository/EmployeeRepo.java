package com.mg.Crud.repository;

import com.mg.Crud.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {

}
