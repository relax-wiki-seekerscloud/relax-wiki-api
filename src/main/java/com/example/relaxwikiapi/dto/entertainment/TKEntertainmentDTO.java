package com.example.relaxwikiapi.dto.entertainment;

import com.example.relaxwikiapi.constants.AppsConstants;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainment;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKEntertainmentDTO {

    private Long entertainmentID;

    private String title;

    private String owner;

    private String address;

    private String mainDescription;

    private String subDescription;

    private Double price;

    private Integer numberOfPeople;

    private AppsConstants.EntertainmentActivity entertainmentActivity;

    private AppsConstants.StarCategory starCategory;

    private AppsConstants.YesNo hasFreeCancellation;

    public TKEntertainmentDTO(TKEntertainment entertainment) {
        this.entertainmentID = entertainment.getEntertainmentID();
        this.title = entertainment.getTitle();
        this.owner = entertainment.getOwner();
        this.address = entertainment.getAddress();
        this.mainDescription = entertainment.getMainDescription();
        this.subDescription = entertainment.getSubDescription();
        this.price = entertainment.getPrice();
        this.numberOfPeople = entertainment.getNumberOfPeople();
        this.entertainmentActivity = entertainment.getEntertainmentActivity();
        this.starCategory = entertainment.getStarCategory();
        this.hasFreeCancellation = entertainment.getHasFreeCancellation();

        for (TKEntertainmentImage entertainmentImage : entertainment.getTkEntertainmentImages()) {
            this.getEntertainmentImageDTOList().add(new TKEntertainmentImageDTO(entertainmentImage));
        }
    }

    private List<TKEntertainmentImageDTO> entertainmentImageDTOList;

    public List<TKEntertainmentImageDTO> getEntertainmentImageDTOList() {
        if (entertainmentImageDTOList == null) {
            entertainmentImageDTOList = new ArrayList<>();
        }
        return entertainmentImageDTOList;
    }

    public void setEntertainmentImageDTOList(List<TKEntertainmentImageDTO> entertainmentImageDTOList) {
        this.entertainmentImageDTOList = entertainmentImageDTOList;
    }
}
