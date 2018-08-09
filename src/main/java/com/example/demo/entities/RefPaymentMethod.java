package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ref_payment_methods", schema = "spring_airline", catalog = "")
public class RefPaymentMethod {
    private int code;
    private int paymentMethodDescription;
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
    @Column(name = "payment_method_description")
    public int getPaymentMethodDescription() {
        return paymentMethodDescription;
    }

    public void setPaymentMethodDescription(int paymentMethodDescription) {
        this.paymentMethodDescription = paymentMethodDescription;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RefPaymentMethod that = (RefPaymentMethod) o;
//        return code == that.code &&
//                paymentMethodDescription == that.paymentMethodDescription;
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(code, paymentMethodDescription);
//    }

    @OneToMany(mappedBy = "refPaymentMethodsByPaymentMethodCode")
    public List<Reservation> getReservationsByCode() {
        return reservationsByCode;
    }

    public void setReservationsByCode(List<Reservation> reservationsByCode) {
        this.reservationsByCode = reservationsByCode;
    }
}
