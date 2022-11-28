package com.example.bookmyshow.respository;

import com.example.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRespository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
