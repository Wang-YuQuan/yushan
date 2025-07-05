package com.example.backend.service;

import com.example.backend.model.SeatStatusDTO;
import com.example.backend.repository.IRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatService {
    private final IRepository repository;

    public SeatService(IRepository repository) {
        this.repository = repository;
    }

    public List<SeatStatusDTO> getSeatStatus() {
        return repository.getSeatStatus();
    }
}
