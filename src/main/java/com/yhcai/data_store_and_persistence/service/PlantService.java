package com.yhcai.data_store_and_persistence.service;

import com.yhcai.data_store_and_persistence.data.Plant;
import com.yhcai.data_store_and_persistence.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        Plant plant = new Plant();
        return plant;
    }

    @Autowired
    PlantRepository plantRepository;

    public Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public Boolean delivered(Long id){
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}