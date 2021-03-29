package com.butterchicken.UberAssistant.dto;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDto {

    @NonNull
    private Integer userId;

    @NonNull
    private Integer restaurantId;

    @NonNull
    private LocalDateTime reservationTime;

}
