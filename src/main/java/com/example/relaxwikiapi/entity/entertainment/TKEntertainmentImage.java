package com.example.relaxwikiapi.entity.entertainment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_entertainment_image")
public class TKEntertainmentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entertainment_image_id")
    private Long entertainmentImageID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entertainment_id")
    private TKEntertainment tkEntertainment;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;

    @Column(name = "image_url", nullable = false)
    private String imageURL;
}
