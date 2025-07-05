package com.example.backend.controller;

import com.example.backend.model.SeatStatusDTO;
import com.example.backend.service.SeatService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @RequestMapping(value = "/api/seat/seatStatus")
    public List<SeatStatusDTO> getSeatStatus() {
        return seatService.getSeatStatus();
    }
}
