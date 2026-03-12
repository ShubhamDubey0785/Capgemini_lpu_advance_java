package com.capgemini.employee.service;

import com.capgemini.employee.entity.Employee;
import com.capgemini.employee.exception.ResourceNotFoundException;
import com.capgemini.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    public Employee update(Long id, Employee emp) {
        Employee existing = getById(id);
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setSalary(emp.getSalary());
        existing.setDepartment(emp.getDepartment());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getByDepartment(String dept) {
        return repository.findByDepartment(dept);
    }

    @Override
    public List<Employee> getHighSalary(double salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public List<Employee> sortBySalary() {
        return repository.findAll(Sort.by("salary"));
    }

    @Override
    public Page<Employee> paginate(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Employee> salaryAboveAverage() {
        return repository.findSalaryAboveAverage();
    }
}