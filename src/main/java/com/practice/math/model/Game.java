package com.practice.math.model;

import javax.persistence.*;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstClub;

    private int firstGoals;

    private int firstShoots;

    private int firstShootsTarget;

    private int firstPasses;

    private int firstPassesTarget;

    private int firstPossession;

    private int firstCorners;

    private int firstDuels;

    private String matchDate;

    private int secondDuels;

    private int secondCorners;

    private int secondPossession;

    private int secondPassesTarget;

    private int secondPasses;

    private int secondShootsTarget;

    private int secondShoots;

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

    public int getFirstShoots() {
        return firstShoots;
    }

    public void setFirstShoots(int firstShoots) {
        this.firstShoots = firstShoots;
    }

    public int getFirstShootsTarget() {
        return firstShootsTarget;
    }

    public void setFirstShootsTarget(int firstShootsTarget) {
        this.firstShootsTarget = firstShootsTarget;
    }

    public int getFirstPasses() {
        return firstPasses;
    }

    public void setFirstPasses(int firstPasses) {
        this.firstPasses = firstPasses;
    }

    public int getFirstPassesTarget() {
        return firstPassesTarget;
    }

    public void setFirstPassesTarget(int firstPassesTarget) {
        this.firstPassesTarget = firstPassesTarget;
    }

    public int getFirstPossession() {
        return firstPossession;
    }

    public void setFirstPossession(int firstPossession) {
        this.firstPossession = firstPossession;
    }

    public int getFirstCorners() {
        return firstCorners;
    }

    public void setFirstCorners(int firstCorners) {
        this.firstCorners = firstCorners;
    }

    public int getFirstDuels() {
        return firstDuels;
    }

    public void setFirstDuels(int firstDuels) {
        this.firstDuels = firstDuels;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public int getSecondDuels() {
        return secondDuels;
    }

    public void setSecondDuels(int secondDuels) {
        this.secondDuels = secondDuels;
    }

    public int getSecondCorners() {
        return secondCorners;
    }

    public void setSecondCorners(int secondCorners) {
        this.secondCorners = secondCorners;
    }

    public int getSecondPossession() {
        return secondPossession;
    }

    public void setSecondPossession(int secondPossession) {
        this.secondPossession = secondPossession;
    }

    public int getSecondPassesTarget() {
        return secondPassesTarget;
    }

    public void setSecondPassesTarget(int secondPassesTarget) {
        this.secondPassesTarget = secondPassesTarget;
    }

    public int getSecondPasses() {
        return secondPasses;
    }

    public void setSecondPasses(int secondPasses) {
        this.secondPasses = secondPasses;
    }

    public int getSecondShootsTarget() {
        return secondShootsTarget;
    }

    public void setSecondShootsTarget(int secondShootsTarget) {
        this.secondShootsTarget = secondShootsTarget;
    }

    public int getSecondShoots() {
        return secondShoots;
    }

    public void setSecondShoots(int secondShoots) {
        this.secondShoots = secondShoots;
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