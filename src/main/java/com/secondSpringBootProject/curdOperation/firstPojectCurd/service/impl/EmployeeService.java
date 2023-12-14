package com.secondSpringBootProject.curdOperation.firstPojectCurd.service.impl;

import com.secondSpringBootProject.curdOperation.firstPojectCurd.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployeesList();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);
}
