package com.practice.math.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESULT")
public class Result {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstClub;

    private double firstRate;

    private String algorithm;

    private double secondRate;

    private String secondClub;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstClub() {
        return firstClub;
    }

    public void setFirstClub(String firstClub) {
        this.firstClub = firstClub;
    }

    public double getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(double firstRate) {
        this.firstRate = firstRate;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public double getSecondRate() {
        return secondRate;
    }

    public void setSecondRate(double secondRate) {
        this.secondRate = secondRate;
    }

    public String getSecondClub() {
        return secondClub;
    }

    public void setSecondClub(String secondClub) {
        this.secondClub = secondClub;
    }

    @Override
    public String toString() {
        return "firstClub=" + firstClub + ", firstRate=" + firstRate +
                ", algorithm=" + algorithm + ", secondRate=" + secondRate +
                ", secondClub=" + secondClub;
    }
}