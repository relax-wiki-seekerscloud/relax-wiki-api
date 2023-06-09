package com.example.relaxwikiapi.dto.entertainment;

import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKEntertainmentImageDTO {

    private Long entertainmentImageID;

    private Long entertainmentID;

    private Integer displayOrder;

    private String imageURL;

    public TKEntertainmentImageDTO(TKEntertainmentImage tkEntertainmentImage) {
        this.entertainmentImageID = tkEntertainmentImage.getEntertainmentImageID();
        this.entertainmentID = tkEntertainmentImage.getTkEntertainment().getEntertainmentID();
        this.displayOrder = tkEntertainmentImage.getDisplayOrder();
        this.imageURL = tkEntertainmentImage.getImageURL();
    }
}
