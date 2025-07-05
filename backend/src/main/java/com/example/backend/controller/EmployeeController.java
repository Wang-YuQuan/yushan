package com.example.backend.controller;

import com.example.backend.model.Employee;
import com.example.backend.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/api/employee/no_seat")
    public List<Employee> getSeatStatus() {
        return employeeService.getEmployeeWithoutSeat();
    }

    @RequestMapping(value = "/api/employee/change_seat")
    public ResponseEntity<String> setSeatStatus(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);

        int MODIFY_EMP_ID = jsonNode.get("MODIFY_EMP_ID").asInt();
        int MODIFY_FLOOR_SEAT_SEQ = jsonNode.get("MODIFY_FLOOR_SEAT_SEQ").asInt();

        employeeService.setSeatStatus(MODIFY_EMP_ID, MODIFY_FLOOR_SEAT_SEQ);
        return ResponseEntity.ok("Saved successfully");
    }

    @RequestMapping(value = "/api/employee/add_employee")
    public ResponseEntity<String> addEmployee(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);

        String name = jsonNode.get("name").asText();
        String email = jsonNode.get("email").asText();

        employeeService.addEmployee(name, email);
        return ResponseEntity.ok("Saved successfully");
    }
}
