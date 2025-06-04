package com.Shift.Management.Shift.Management.Dto;

import java.time.LocalDate;
import java.util.Objects;

public class DtoShift {
    private Long id;
    private String staffName;
    private LocalDate date;
    private String time;

    public DtoShift() {
        super();
    }

    public DtoShift(Long id, String staffName, LocalDate date, String time) {
        this.id = id;
        this.staffName = staffName;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DtoShift dtoShift = (DtoShift) o;
        return Objects.equals(getId(), dtoShift.getId()) && Objects.equals(getStaffName(), dtoShift.getStaffName()) && Objects.equals(getDate(), dtoShift.getDate()) && Objects.equals(getTime(), dtoShift.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStaffName(), getDate(), getTime());
    }

    @Override
    public String toString() {
        return "DtoShift{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}
