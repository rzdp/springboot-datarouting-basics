package com.rzdp.staticdatasourcerouting.service;

import com.rzdp.staticdatasourcerouting.entity.Employee;
import com.rzdp.staticdatasourcerouting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
