package com.butterchicken.UberAssistant.service.impl;

import com.butterchicken.UberAssistant.dto.ReservationRequestDto;
import com.butterchicken.UberAssistant.entity.Reservation;
import com.butterchicken.UberAssistant.repo.ReservationRepo;
import com.butterchicken.UberAssistant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public Reservation makeReservation(ReservationRequestDto reservationRequest) {
        return reservationRepo.save(new Reservation(reservationRequest.getUserId(), reservationRequest.getRestaurantId(), reservationRequest.getReservationTime()));
    }
}
