package com.butterchicken.UberAssistant.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "open_time")
    private String openTime;

    @Column(name = "closing_time")
    private String closingTime;

    @Column(name = "cost_for_one")
    private Integer costForOne;

    @Column(name = "image_url")
    private String image_url;
}
