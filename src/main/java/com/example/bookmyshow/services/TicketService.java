package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.respository.ShowSeatRepository;
import com.example.bookmyshow.respository.TicketRespository;
import com.example.bookmyshow.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private TicketRespository ticketRespository;

    private UserRespository userRespository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, TicketRespository ticketRespository,
                         UserRespository userRespository) {
        this.showSeatRepository = showSeatRepository;
        this.ticketRespository = ticketRespository;
        this.userRespository = userRespository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds, Long userId, Long showId) throws ShowSeatNotAvailableException {
        List<ShowSeat> showSeatList = showSeatRepository.findAllByIdIn(showSeatIds);

        for(ShowSeat showSeat: showSeatList){
            if(!showSeat.getState().equals(ShowSeatState.AVAILABLE)){
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }

        for(ShowSeat showSeat: showSeatList){
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();

        Optional<User> userOptional = userRespository.findById(userId);
        if(userOptional.isEmpty()){

        }
        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setShowSeatList(showSeatList);

        return ticketRespository.save(ticket);
    }
}
