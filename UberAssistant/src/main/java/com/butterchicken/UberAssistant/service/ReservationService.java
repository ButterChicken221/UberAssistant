package com.butterchicken.UberAssistant.service;

import com.butterchicken.UberAssistant.dto.ReservationRequestDto;
import com.butterchicken.UberAssistant.entity.Reservation;

public interface ReservationService {

    Reservation makeReservation(ReservationRequestDto reservationRequest);

}
