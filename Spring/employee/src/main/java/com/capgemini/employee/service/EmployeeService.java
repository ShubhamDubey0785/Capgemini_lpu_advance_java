package com.capgemini.employee.service;

import com.capgemini.employee.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee update(Long id, Employee employee);
    void delete(Long id);
    List<Employee> getByDepartment(String dept);
    List<Employee> getHighSalary(double salary);
    long count();
    List<Employee> sortBySalary();
    Page<Employee> paginate(int page, int size);
    List<Employee> salaryAboveAverage();
}