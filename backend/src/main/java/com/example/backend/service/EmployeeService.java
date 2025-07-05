package com.example.backend.service;

import com.example.backend.model.Employee;
import com.example.backend.model.SeatStatusDTO;
import com.example.backend.repository.IRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    private final IRepository repository;

    public EmployeeService(IRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getEmployeeWithoutSeat() {
        return repository.getEmployeeWithoutSeat();
    }

    public void setSeatStatus(int MODIFY_EMP_ID, int MODIFY_FLOOR_SEAT_SEQ) {
        List<SeatStatusDTO> dtos = repository.getSeatStatus();
        boolean shouldSkip = dtos.stream()
                .anyMatch(dto -> dto.getEmp_id() == MODIFY_EMP_ID && dto.getFloor_seat_seq() != MODIFY_FLOOR_SEAT_SEQ && MODIFY_EMP_ID != 0);

        if (shouldSkip) {
            return;
        }
        this.repository.setSeatStatus(MODIFY_EMP_ID, MODIFY_FLOOR_SEAT_SEQ);
    }

    public void addEmployee(String name, String email) {
        this.repository.addEmployee(name, email);
    }
}
