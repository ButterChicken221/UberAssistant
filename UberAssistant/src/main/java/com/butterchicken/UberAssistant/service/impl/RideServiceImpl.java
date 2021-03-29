package com.butterchicken.UberAssistant.service.impl;

import com.butterchicken.UberAssistant.dto.RideDto;
import com.butterchicken.UberAssistant.entity.Ride;
import com.butterchicken.UberAssistant.repo.RideRepo;
import com.butterchicken.UberAssistant.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepo rideRepo;

    @Override
    public List<RideDto> getRideHistory(Integer userId, Integer page, Integer size) {
        Sort sortBy = Sort.by("id").descending();
        List<Ride> rideHistory = rideRepo.findByUserId(userId, PageRequest.of(page, size, sortBy));
        return rideHistory.stream().map(e -> getRideResponseDto(e)).collect(Collectors.toList());
    }

    private RideDto getRideResponseDto(Ride ride) {
        RideDto rideDto = RideDto.builder().userId(ride.getUserId())
                    .source(new RideDto.LatLong(ride.getSourceLat(), ride.getSourceLong()))
                        .destination(new RideDto.LatLong(ride.getDestLat(), ride.getDestLong()))
                        .fare(ride.getFare()).startTime(ride.getStartTime()).endTime(ride.getEndTime())
                        .cabTypeCode(ride.getCabType().getCabTypeCode()).build();
        return rideDto;
    }
}
