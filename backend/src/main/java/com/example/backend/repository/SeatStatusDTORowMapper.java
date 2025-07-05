package com.example.backend.repository;

import com.example.backend.model.SeatStatusDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatStatusDTORowMapper implements RowMapper<SeatStatusDTO> {
    @Override
    public SeatStatusDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SeatStatusDTO seatStatusDTO = new SeatStatusDTO();
        seatStatusDTO.setSeat_no(rs.getInt("seat_no"));
        seatStatusDTO.setEmp_id(rs.getInt("emp_id"));
        seatStatusDTO.setName(rs.getString("name"));
        seatStatusDTO.setFloor_seat_seq(rs.getInt("floor_seat_seq"));
        seatStatusDTO.setFloor_no(rs.getInt("floor_no"));
        return seatStatusDTO;
    }
}
