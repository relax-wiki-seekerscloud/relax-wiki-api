package com.example.relaxwikiapi.service.restaurant;

import com.example.relaxwikiapi.dto.restaurant.*;
import com.example.relaxwikiapi.entity.restaurant.*;
import com.example.relaxwikiapi.exception.AppsException;
import com.example.relaxwikiapi.repository.restaurant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TKRestaurantServiceImpl implements TKRestaurantService {

    @Autowired
    private TKRestaurantRepository tkRestaurantRepository;

    @Autowired
    private TKRestaurantImageRepository tkRestaurantImageRepository;

    @Autowired
    private TKRestaurantReviewRepository tkRestaurantReviewRepository;

    @Autowired
    private TKRestaurantFoodCategoryRepository tkRestaurantFoodCategoryRepository;

    @Autowired
    private TKRestaurantJDBCRepository tkRestaurantJDBCRepository;

    @Autowired
    private TKRestaurantFoodCategoryFoodRepository tkRestaurantFoodCategoryFoodRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TKRestaurantDTO> searchRestaurants(TKRestaurantSearchRQ searchRQ) throws AppsException {
        List<TKRestaurantDTO> restaurantDTOList = this.tkRestaurantJDBCRepository.searchRestaurants(searchRQ);

        for (TKRestaurantDTO restaurantDTO : restaurantDTOList) {
            TKRestaurant restaurant = this.tkRestaurantRepository.getReferenceById(restaurantDTO.getRestaurantID());

            for (TKRestaurantImage restaurantImage : this.tkRestaurantImageRepository.findAllByTkRestaurant(restaurant)) {
                restaurantDTO.getRestaurantImageDTOList().add(new TKRestaurantImageDTO(restaurantImage));
            }

            for (TKRestaurantReview restaurantReview : this.tkRestaurantReviewRepository.findAllByTkRestaurant(restaurant)) {
                restaurantDTO.getRestaurantReviewDTOList().add(new TKRestaurantReviewDTO(restaurantReview));
            }

            for (TKRestaurantFoodCategory restaurantFoodCategory : this.tkRestaurantFoodCategoryRepository.findAllByTkRestaurant(restaurant)) {
                TKRestaurantFoodCategoryDTO restaurantFoodCategoryDTO = new TKRestaurantFoodCategoryDTO(restaurantFoodCategory);

                for (TKRestaurantFoodCategoryFood restaurantFoodCategoryFood : this.tkRestaurantFoodCategoryFoodRepository.findAllByTkRestaurantFoodCategory(restaurantFoodCategory)) {
                    restaurantFoodCategoryDTO.getFoodDTOList().add(new TKRestaurantFoodCategoryFoodDTO(restaurantFoodCategoryFood));
                }
                restaurantDTO.getRestaurantFoodCategoryDTOList().add(restaurantFoodCategoryDTO);
            }
        }

        return restaurantDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TKRestaurantDTO findRestaurantByID(Long restaurantID) throws AppsException {
        TKRestaurant restaurant = this.tkRestaurantRepository.getReferenceById(restaurantID);
        TKRestaurantDTO restaurantDTO = new TKRestaurantDTO(restaurant);

        for (TKRestaurantImage restaurantImage : this.tkRestaurantImageRepository.findAllByTkRestaurant(restaurant)) {
            restaurantDTO.getRestaurantImageDTOList().add(new TKRestaurantImageDTO(restaurantImage));
        }

        for (TKRestaurantReview restaurantReview : this.tkRestaurantReviewRepository.findAllByTkRestaurant(restaurant)) {
            restaurantDTO.getRestaurantReviewDTOList().add(new TKRestaurantReviewDTO(restaurantReview));
        }

        for (TKRestaurantFoodCategory restaurantFoodCategory : this.tkRestaurantFoodCategoryRepository.findAllByTkRestaurant(restaurant)) {
            TKRestaurantFoodCategoryDTO restaurantFoodCategoryDTO = new TKRestaurantFoodCategoryDTO(restaurantFoodCategory);

            for (TKRestaurantFoodCategoryFood restaurantFoodCategoryFood : this.tkRestaurantFoodCategoryFoodRepository.findAllByTkRestaurantFoodCategory(restaurantFoodCategory)) {
                restaurantFoodCategoryDTO.getFoodDTOList().add(new TKRestaurantFoodCategoryFoodDTO(restaurantFoodCategoryFood));
            }
            restaurantDTO.getRestaurantFoodCategoryDTOList().add(restaurantFoodCategoryDTO);
        }

        return restaurantDTO;
    }
}
