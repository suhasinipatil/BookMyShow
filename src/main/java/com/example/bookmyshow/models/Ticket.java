package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Ticket extends BaseModel{
    private double totalAmount;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeatList;

    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Auditorium auditorium;

    private Date timeOfBooking;

    @OneToMany
    private List<Payment> paymentList;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
