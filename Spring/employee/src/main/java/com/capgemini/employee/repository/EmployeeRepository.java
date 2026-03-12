package com.capgemini.employee.repository;

import com.capgemini.employee.entity.Employee;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)")
    List<Employee> findSalaryAboveAverage();
}