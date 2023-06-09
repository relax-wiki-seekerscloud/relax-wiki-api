package com.example.relaxwikiapi.repository.entertainment;

import com.example.relaxwikiapi.entity.entertainment.TKEntertainment;
import com.example.relaxwikiapi.entity.entertainment.TKEntertainmentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKEntertainmentImageRepository extends JpaRepository<TKEntertainmentImage, Long> {

    List<TKEntertainmentImage> findAllByTkEntertainment(TKEntertainment tkEntertainment);
}
