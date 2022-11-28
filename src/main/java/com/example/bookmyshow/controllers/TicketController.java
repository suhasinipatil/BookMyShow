package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequestDto;
import com.example.bookmyshow.dtos.BookTicketResponseDto;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.TicketService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    private BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws ShowSeatNotAvailableException {
        Ticket ticket = ticketService.bookTicket(
                bookTicketRequestDto.getShowSeatIds(),
                bookTicketRequestDto.getUserID(),
                bookTicketRequestDto.getShowID()
        );

        return null;
    }
}
