package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ref_reservation_status", schema = "spring_airline", catalog = "")
public class RefReservationStatus {
    private int code;
    private String reservationStatusDescription;
    private List<Reservation> reservationsByCode;

    @Id
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "reservation_status_description")
    public String getReservationStatusDescription() {
        return reservationStatusDescription;
    }

    public void setReservationStatusDescription(String reservationStatusDescription) {
        this.reservationStatusDescription = reservationStatusDescription;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RefReservationStatus that = (RefReservationStatus) o;
//        return code == that.code &&
//                Objects.equals(reservationStatusDescription, that.reservationStatusDescription);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(code, reservationStatusDescription);
//    }

    @OneToMany(mappedBy = "refReservationStatusByReservationStatusCode")
    public List<Reservation> getReservationsByCode() {
        return reservationsByCode;
    }

    public void setReservationsByCode(List<Reservation> reservationsByCode) {
        this.reservationsByCode = reservationsByCode;
    }
}
