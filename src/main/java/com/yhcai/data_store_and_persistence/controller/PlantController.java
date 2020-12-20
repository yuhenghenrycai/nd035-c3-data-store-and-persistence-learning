package com.yhcai.data_store_and_persistence.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yhcai.data_store_and_persistence.data.Plant;
import com.yhcai.data_store_and_persistence.data.PlantDTO;
import com.yhcai.data_store_and_persistence.data.Views;
import com.yhcai.data_store_and_persistence.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        return convertPlantToPlantDTO(plant);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plantDTO, plant);
        return plantDTO;
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }
}