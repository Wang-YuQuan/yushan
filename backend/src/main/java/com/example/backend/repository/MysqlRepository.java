package com.example.backend.repository;
import com.example.backend.model.Employee;
import com.example.backend.model.SeatStatusDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MysqlRepository implements IRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MysqlRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<SeatStatusDTO> getSeatStatus() {
        String sql = "CALL getSeatStatus()";
        Map<String, Object> params = new HashMap<>();
        SeatStatusDTORowMapper rowMapper = new SeatStatusDTORowMapper();
        return namedParameterJdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public List<Employee> getEmployeeWithoutSeat() {
        String sql = "CALL getEmployeeWithoutSeat()";
        Map<String, Object> params = new HashMap<>();
        EmployeeRowMapper rowMapper = new EmployeeRowMapper();
        return namedParameterJdbcTemplate.query(sql, params, rowMapper);
    }

    @Override
    public void setSeatStatus(int MODIFY_EMP_ID, int MODIFY_FLOOR_SEAT_SEQ) {
        String sql = "call setSeatStatus(:MODIFY_EMP_ID, :MODIFY_FLOOR_SEAT_SEQ)";
        Map<String, Object> params = new HashMap<>();
        params.put("MODIFY_EMP_ID", MODIFY_EMP_ID);
        params.put("MODIFY_FLOOR_SEAT_SEQ", MODIFY_FLOOR_SEAT_SEQ);

        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void addEmployee(String name, String email) {
        String sql = "call addEmployee(:name, :email)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);

        namedParameterJdbcTemplate.update(sql, params);
    }
}
