package com.example.bookmyshow.respository;

import com.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);
/*
    List<ShowSeat> findAllByStateEquals(ShowSeatState showSeatState);


    Optional<ShowSeat> findByState(Seat seat);*/
}
