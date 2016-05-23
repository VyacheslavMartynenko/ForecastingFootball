package com.practice.math.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstClub;

    private int firstGoals;

    private String matchDate;

    private int secondGoals;

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

    public int getFirstGoals() {
        return firstGoals;
    }

    public void setFirstGoals(int firstGoals) {
        this.firstGoals = firstGoals;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public int getSecondGoals() {
        return secondGoals;
    }

    public void setSecondGoals(int secondGoals) {
        this.secondGoals = secondGoals;
    }

    public String getSecondClub() {
        return secondClub;
    }

    public void setSecondClub(String secondClub) {
        this.secondClub = secondClub;
    }

    @Override
    public String toString() {
        return "firstClub=" + firstClub + ", firstGoals=" + firstGoals +
                ", matchDate=" + matchDate + ", secondGoals=" + secondGoals +
                ", secondClub=" + secondClub;
    }
}