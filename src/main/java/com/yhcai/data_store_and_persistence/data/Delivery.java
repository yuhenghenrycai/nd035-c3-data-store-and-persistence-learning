package com.yhcai.data_store_and_persistence.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name = "Delivery.findByName",
        query = "select d from Delivery as d where d.name = :name")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime;
    @Type(type = "yes_no")
    private Boolean completed;

    //make sure to specify mappedBy. Lazy fetch optional,
    //  but often a good idea for collection attributes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    /* getters and setters */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
