package com.butterchicken.UberAssistant.controller;

import com.butterchicken.UberAssistant.dto.RideDto;
import com.butterchicken.UberAssistant.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<RideDto> getAllRestaurants(@RequestParam Integer userId, @RequestParam Integer page, @RequestParam Integer size) {
        return rideService.getRideHistory(userId, page, size);
    }

}
