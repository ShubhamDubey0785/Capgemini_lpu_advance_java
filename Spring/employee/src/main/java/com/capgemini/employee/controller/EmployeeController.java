package com.capgemini.employee.controller;

import com.capgemini.employee.entity.Employee;
import com.capgemini.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }

    @GetMapping("/department/{name}")
    public List<Employee> byDepartment(@PathVariable String name) {
        return service.getByDepartment(name);
    }

    @GetMapping("/highsalary")
    public List<Employee> highSalary(@RequestParam double salary) {
        return service.getHighSalary(salary);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @GetMapping("/sort")
    public List<Employee> sort() {
        return service.sortBySalary();
    }

    @GetMapping("/page")
    public Page<Employee> page(@RequestParam int page,
                               @RequestParam int size) {
        return service.paginate(page, size);
    }

    @GetMapping("/above-average")
    public List<Employee> aboveAverage() {
        return service.salaryAboveAverage();
    }
}