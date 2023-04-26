package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity

public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Lob
    private String description;

    @Lob
    private int price;

    @Lob
    private byte[] photos;

    private  int rates;


    @OneToMany(targetEntity = ActivityCenter.class, cascade = CascadeType.ALL )
    @JoinColumn(name= "aac_fk", referencedColumnName = "id")
    private List<ActivityCenter> activityCenter;

    @OneToMany(targetEntity = ActivityAvailability.class, cascade = CascadeType.ALL )
    @JoinColumn(name= "aac_fk", referencedColumnName = "id")
    private List<ActivityAvailability> activityAvailability;




}
