package com.secondSpringBootProject.curdOperation.firstPojectCurd.service.impl;

import com.secondSpringBootProject.curdOperation.firstPojectCurd.exception.ResourceNotFoundExcepation;
import com.secondSpringBootProject.curdOperation.firstPojectCurd.model.Employee;
import com.secondSpringBootProject.curdOperation.firstPojectCurd.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
//        Optional<Employee> employee=employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else{
//             throw new ResourceNotFoundExcepation("Employee","ID",id);
//        }
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundExcepation("Employee","ID",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee employeeEx= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundExcepation("Employee","ID",id));

         employeeEx.setFname(employee.getFname());
         employeeEx.setLname(employee.getLname());
         employeeEx.setEmailId(employee.getEmailId());
         //Saving into DB
         employeeRepository.save(employeeEx);
        return employeeEx;
    }

    @Override
    public void deleteEmployee(int id) {
        //check employee in DB or not
        employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundExcepation("Employee","ID",id));
       employeeRepository.deleteById(id);
    }
}
