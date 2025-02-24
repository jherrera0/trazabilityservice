package com.backendchallenge.traceabilityservice.domain.model;

import java.util.List;

public class Order {
    private Long id;
    private Long idClient;
    private Long idEmployee;
    private Long idRestaurant;
    private List<OrderedDish> dishes;
    private List<StatusChange> statusChanges;

    public Order() {
    }

    public Order(Long id, Long idClient, Long idEmployee, Long idRestaurant, List<OrderedDish> dishes,
                 List<StatusChange> statusChanges) {
        this.id = id;
        this.idClient = idClient;
        this.idEmployee = idEmployee;
        this.idRestaurant = idRestaurant;
        this.dishes = dishes;
        this.statusChanges = statusChanges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public List<OrderedDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderedDish> dishes) {
        this.dishes = dishes;
    }

    public List<StatusChange> getStatusChanges() {
        return statusChanges;
    }

    public void setStatusChanges(List<StatusChange> statusChanges) {
        this.statusChanges = statusChanges;
    }

}
