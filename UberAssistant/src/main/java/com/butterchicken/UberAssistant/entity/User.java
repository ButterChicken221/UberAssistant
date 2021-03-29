package com.butterchicken.UberAssistant.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_details")
public class User extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}
