package com.example.relaxwikiapi.dto;

import com.example.relaxwikiapi.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityDTO {

    private Activity activity;
    private double totalPrice;

    public ActivityDTO(Activity activity, int numOfPeople) {
        this.activity = activity;
        this.totalPrice = activity.getPrice() * numOfPeople;
    }

}
