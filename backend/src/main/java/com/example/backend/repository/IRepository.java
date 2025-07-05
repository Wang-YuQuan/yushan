package com.example.backend.repository;

import com.example.backend.model.Employee;
import com.example.backend.model.SeatStatusDTO;

import java.util.List;

public interface IRepository {
    public List<SeatStatusDTO> getSeatStatus();
    public List<Employee> getEmployeeWithoutSeat();
    public void setSeatStatus(int MODIFY_EMP_ID, int MODIFY_FLOOR_SEAT_SEQ);
}
