package com.butterchicken.UberAssistant.service.impl;

import com.butterchicken.UberAssistant.entity.Restaurant;
import com.butterchicken.UberAssistant.repo.RestaurantRepo;
import com.butterchicken.UberAssistant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }
}
