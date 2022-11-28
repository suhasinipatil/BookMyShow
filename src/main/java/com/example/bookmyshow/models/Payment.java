package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private Mode mode;

    private double amount;

    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    private Date timeOfPayment;

    private String referenceId;
}
