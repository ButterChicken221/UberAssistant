package com.butterchicken.UberAssistant.repo;

import com.butterchicken.UberAssistant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
