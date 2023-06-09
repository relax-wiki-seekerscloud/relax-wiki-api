package com.example.relaxwikiapi.entity.entertainment;

import com.example.relaxwikiapi.constants.AppsConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tk_entertainment")
public class TKEntertainment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entertainment_id")
    private Long entertainmentID;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "main_description")
    private String mainDescription;

    @Column(name = "sub_description")
    private String subDescription;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "number_of_people", nullable = false)
    private Integer numberOfPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity", nullable = false, length = 50)
    private AppsConstants.EntertainmentActivity entertainmentActivity;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_category", nullable = false, length = 50)
    private AppsConstants.StarCategory starCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "has_free_cancellation", nullable = false, length = 2)
    private AppsConstants.YesNo hasFreeCancellation;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "tkEntertainment")
    private Set<TKEntertainmentImage> tkEntertainmentImages;

    public Set<TKEntertainmentImage> getTkEntertainmentImages() {
        if (tkEntertainmentImages == null) {
            tkEntertainmentImages = new HashSet<>();
        }
        return tkEntertainmentImages;
    }

    public void setTkEntertainmentImages(Set<TKEntertainmentImage> tkEntertainmentImages) {
        this.tkEntertainmentImages = tkEntertainmentImages;
    }
}
