package com.springbootbackend.backend.Controller;

import com.springbootbackend.backend.Entity.Employee;
import com.springbootbackend.backend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class  EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping("/addemp")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        Employee employee = employeeRepository.findById(id).get();
        return ResponseEntity.ok(employee);
    }
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employeedetails)
    {
        Employee employee = employeeRepository.findById(id).get();
//        employee.setEmployee_id(employeedetails.getEmployee_id());
        employee.setFirst_name(employeedetails.getFirst_name());
        employee.setLast_name(employeedetails.getLast_name());
        employee.setEmail_id(employeedetails.getEmail_id());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }



}
