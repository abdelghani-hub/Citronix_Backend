package com.youcode.citronix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "client_name")
    private String clientName;

    private double quantity;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    public Sale() {
    }

    public Sale(double unitPrice, String clientName, double quantity, LocalDate date) {
        this.unitPrice = unitPrice;
        this.clientName = clientName;
        this.quantity = quantity;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Harvest getHarvest() {
        return harvest;
    }

    public void setHarvest(Harvest harvest) {
        this.harvest = harvest;
    }

    public Double getRevenue() {
        return this.unitPrice * this.quantity;
    }
}
