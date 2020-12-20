package com.yhcai.data_store_and_persistence.controller;

import com.yhcai.data_store_and_persistence.data.Delivery;
import com.yhcai.data_store_and_persistence.data.RecipientAndPrice;
import com.yhcai.data_store_and_persistence.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }

    @GetMapping("/order/{name}")
    public List<Delivery> getDeliveryByName(@PathVariable String name) {
        return deliveryService.findDeliveryServiceByName(name);
    }
}
