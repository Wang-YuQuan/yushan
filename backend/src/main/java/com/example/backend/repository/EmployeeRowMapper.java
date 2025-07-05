package com.example.backend.repository;

import com.example.backend.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmp_id(rs.getInt("emp_id"));
        employee.setName(rs.getString("name"));
        employee.setEmail(rs.getString("email"));
        return employee;
    }
}
