package com.Shift.Management.Shift.Management.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name ="shift")
public class EntityShift {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String staffName;
        private LocalDate date;
        private String time;

    public EntityShift(Long id, String staffName, LocalDate date, String time) {
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
        EntityShift that = (EntityShift) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStaffName(), that.getStaffName()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStaffName(), getDate(), getTime());
    }

    @Override
    public String toString() {
        return "EntityShift{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }

    public EntityShift() {
        super();
    }
}
