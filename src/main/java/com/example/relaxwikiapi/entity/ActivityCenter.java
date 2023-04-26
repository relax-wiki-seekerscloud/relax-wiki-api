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

public class ActivityCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = ActivityCenterLocation.class, cascade = CascadeType.ALL )
    @JoinColumn(name= "acl_fk", referencedColumnName = "id")
    private List<ActivityCenterLocation> activityCenterLocation;

    private String telephoneNo;

    @Lob
    private byte[] photos;

}
