package com.example.relaxwikiapi.entity.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_restaurant_image")
public class TKRestaurantImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_image_id")
    private Long restaurantImageID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private TKRestaurant tkRestaurant;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;

    @Column(name = "image_url", nullable = false)
    private String imageURL;
}
