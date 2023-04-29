package com.example.relaxwikiapi.dto;

import com.example.relaxwikiapi.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReviewDTO {

    private Review review;
}
