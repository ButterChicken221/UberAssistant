package com.butterchicken.UberAssistant.service;

import com.butterchicken.UberAssistant.dto.RideDto;

import java.util.List;

public interface RideService {

    List<RideDto> getRideHistory(Integer userId, Integer page, Integer size);
}
