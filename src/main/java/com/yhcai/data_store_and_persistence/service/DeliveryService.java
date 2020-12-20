package com.yhcai.data_store_and_persistence.service;

import com.yhcai.data_store_and_persistence.data.Delivery;
import com.yhcai.data_store_and_persistence.data.RecipientAndPrice;
import com.yhcai.data_store_and_persistence.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public List<Delivery> findDeliveryServiceByName(String name){
        return deliveryRepository.findDeliveriesByName(name);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }


}
