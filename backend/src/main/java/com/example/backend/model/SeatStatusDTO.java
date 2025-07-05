package com.example.backend.model;

public class SeatStatusDTO {
    private int floor_seat_seq;
    private int floor_no;
    private int seat_no;
    private int emp_id;
    private String name;

    public SeatStatusDTO() {

    }

    public SeatStatusDTO(int floor_seat_seq, int floor_no, int seat_no, int emp_id, String name) {
        this.floor_seat_seq = floor_seat_seq;
        this.floor_no = floor_no;
        this.seat_no = seat_no;
        this.emp_id = emp_id;
        this.name = name;
    }

    public int getFloor_seat_seq() {
        return floor_seat_seq;
    }

    public int getFloor_no() {
        return floor_no;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public void setFloor_seat_seq(int floor_seat_seq) {
        this.floor_seat_seq = floor_seat_seq;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
