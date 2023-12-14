package com.secondSpringBootProject.curdOperation.firstPojectCurd.repository;

import com.secondSpringBootProject.curdOperation.firstPojectCurd.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
