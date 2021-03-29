package com.butterchicken.UberAssistant.controller;

import com.butterchicken.UberAssistant.dto.ReservationRequestDto;
import com.butterchicken.UberAssistant.entity.Reservation;
import com.butterchicken.UberAssistant.entity.Restaurant;
import com.butterchicken.UberAssistant.service.ReservationService;
import com.butterchicken.UberAssistant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public Reservation makeReservation(@RequestBody ReservationRequestDto reservationRequest){
        return reservationService.makeReservation(reservationRequest);
    }

}
