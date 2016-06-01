package com.practice.math.algorithm;

import com.practice.math.model.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class UniversalModeling {
    private List<Player> firstClubPlayers;
    private List<Player> secondClubPlayers;

    private double firstRating;
    private double secondRating;

    private double firstRate;
    private double secondRate;

    public UniversalModeling(List<Player> firstClubPlayers, List<Player> secondClubPlayers) {
        this.firstClubPlayers = firstClubPlayers;
        this.secondClubPlayers = secondClubPlayers;
        calculateRatings();
        calculateRates();
    }

    private void calculateRatings() {
        for (Player player : firstClubPlayers) {
            switch (player.getPosition()) {
                case "Striker":
                    firstRating += player.getSpeed() * 0.8;
                    firstRating += player.getDribbling() * 0.6;
                    firstRating += player.getShoot() * 0.9;
                    firstRating += player.getPass() * 0.6;
                    firstRating += player.getDefence() * 0.3;
                    firstRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Midfielder":
                    firstRating += player.getSpeed() * 0.7;
                    firstRating += player.getDribbling() * 0.8;
                    firstRating += player.getShoot() * 0.7;
                    firstRating += player.getPass() * 0.9;
                    firstRating += player.getDefence() * 0.6;
                    firstRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Defender":
                    firstRating += player.getSpeed() * 0.6;
                    firstRating += player.getDribbling() * 0.4;
                    firstRating += player.getShoot() * 0.3;
                    firstRating += player.getPass() * 0.7;
                    firstRating += player.getDefence() * 0.9;
                    firstRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Goalkeeper":
                    firstRating += player.getSpeed() * 0.5;
                    firstRating += player.getDribbling() * 0.2;
                    firstRating += player.getShoot() * 0.1;
                    firstRating += player.getPass() * 0.6;
                    firstRating += player.getDefence() * 0.3;
                    firstRating += player.getGoalkeeper() * 0.9;
                    break;
            }
            firstRating = firstRating / firstClubPlayers.size();
        }
        for (Player player : secondClubPlayers) {
            switch (player.getPosition()) {
                case "Striker":
                    secondRating += player.getSpeed() * 0.8;
                    secondRating += player.getDribbling() * 0.6;
                    secondRating += player.getShoot() * 0.9;
                    secondRating += player.getPass() * 0.6;
                    secondRating += player.getDefence() * 0.3;
                    secondRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Midfielder":
                    secondRating += player.getSpeed() * 0.7;
                    secondRating += player.getDribbling() * 0.8;
                    secondRating += player.getShoot() * 0.7;
                    secondRating += player.getPass() * 0.9;
                    secondRating += player.getDefence() * 0.6;
                    secondRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Defender":
                    secondRating += player.getSpeed() * 0.6;
                    secondRating += player.getDribbling() * 0.4;
                    secondRating += player.getShoot() * 0.3;
                    secondRating += player.getPass() * 0.7;
                    secondRating += player.getDefence() * 0.9;
                    secondRating += player.getGoalkeeper() * 0.1;
                    break;
                case "Goalkeeper":
                    secondRating += player.getSpeed() * 0.5;
                    secondRating += player.getDribbling() * 0.2;
                    secondRating += player.getShoot() * 0.1;
                    secondRating += player.getPass() * 0.6;
                    secondRating += player.getDefence() * 0.3;
                    secondRating += player.getGoalkeeper() * 0.9;
                    break;
            }
            secondRating = secondRating / secondClubPlayers.size();
        }
    }

    private void calculateRates() {
        double firstWinning = firstRating / 100;
        double secondWinning = secondRating / 100;

        double firstAdvantage = 0.8 * (firstWinning / (1 - firstWinning));
        double secondAdvantage = 0.8 * (secondWinning / (1 - secondWinning));

        double firstInfo = Math.sqrt(firstAdvantage * firstAdvantage + 1);
        double secondInfo = Math.sqrt(secondAdvantage * secondAdvantage + 1);

        double firstAdvantageDifference = firstAdvantage * secondInfo - secondAdvantage * firstInfo + 1;
        double secondAdvantageDifference = secondAdvantage * firstInfo - firstAdvantage * secondInfo + 1;

        double firstInfoDifference = Math.sqrt(firstAdvantageDifference * firstAdvantageDifference + 1);
        double secondInfoDifference = Math.sqrt(secondAdvantageDifference * secondAdvantageDifference + 1);

        double firstPrediction = firstAdvantageDifference + firstInfoDifference;
        double secondPrediction = secondAdvantageDifference + secondInfoDifference;

        firstRate = firstPrediction / (firstPrediction + secondPrediction);
        secondRate = secondPrediction / (firstPrediction + secondPrediction);
    }

    public double getFirstRate() {
        return new BigDecimal(firstRate * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getSecondRate() {
        return new BigDecimal(secondRate * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
