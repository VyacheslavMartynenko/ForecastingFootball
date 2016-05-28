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

    private int firstInjures;

    private int firstRest;

    private int firstAttack;

    private int firstDefence;

    private double firstRate;

    private String algorithm;

    private double secondRate;

    private int secondDefence;

    private int secondAttack;

    private int secondRest;

    private int secondInjures;

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

    public int getFirstInjures() {
        return firstInjures;
    }

    public void setFirstInjures(int firstInjures) {
        this.firstInjures = firstInjures;
    }

    public int getFirstRest() {
        return firstRest;
    }

    public void setFirstRest(int firstRest) {
        this.firstRest = firstRest;
    }

    public int getFirstAttack() {
        return firstAttack;
    }

    public void setFirstAttack(int firstAttack) {
        this.firstAttack = firstAttack;
    }

    public int getFirstDefence() {
        return firstDefence;
    }

    public void setFirstDefence(int firstDefence) {
        this.firstDefence = firstDefence;
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

    public int getSecondDefence() {
        return secondDefence;
    }

    public void setSecondDefence(int secondDefence) {
        this.secondDefence = secondDefence;
    }

    public int getSecondAttack() {
        return secondAttack;
    }

    public void setSecondAttack(int secondAttack) {
        this.secondAttack = secondAttack;
    }

    public int getSecondRest() {
        return secondRest;
    }

    public void setSecondRest(int secondRest) {
        this.secondRest = secondRest;
    }

    public int getSecondInjures() {
        return secondInjures;
    }

    public void setSecondInjures(int secondInjures) {
        this.secondInjures = secondInjures;
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