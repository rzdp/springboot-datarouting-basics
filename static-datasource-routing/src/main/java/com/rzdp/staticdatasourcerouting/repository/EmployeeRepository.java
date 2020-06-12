package com.rzdp.staticdatasourcerouting.repository;

import com.rzdp.staticdatasourcerouting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
