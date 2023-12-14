package com.secondSpringBootProject.curdOperation.firstPojectCurd.controller;

import com.secondSpringBootProject.curdOperation.firstPojectCurd.model.Employee;
import com.secondSpringBootProject.curdOperation.firstPojectCurd.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //Build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
        System.out.println(employee.toString());
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //Create REST API for get list of all employee present in DB
    @GetMapping
      public List<Employee> getAllEmpList(){
        return employeeService.getAllEmployeesList();
      }

      //Create REST API for finding the employee by ID
    @GetMapping("{id}")
       public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
       }

       //Create REST API for Update employee Details
    @PutMapping("{Id}")
       public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee,@PathVariable("Id") int id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
       }
       //Create REST API for Delete the employee from DB using Id
    @DeleteMapping("{Id}")
    private ResponseEntity<String> deleteEmployeeByid(@PathVariable ("Id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("The employee Is deleted",HttpStatus.OK);

    }
}
