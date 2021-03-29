package com.butterchicken.UberAssistant.entity;

import com.butterchicken.UberAssistant.enums.CabType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ride_details")
public class Ride extends AbstractEntity{

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "source_lat")
    private Double sourceLat;

    @Column(name = "source_long")
    private Double sourceLong;

    @Column(name = "dest_lat")
    private Double destLat;

    @Column(name = "dest_long")
    private Double destLong;

    @Column(name = "fare")
    private Double fare;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "cab_type")
    @Enumerated(EnumType.STRING)
    private CabType cabType;

}
