package com.practice.math.algorithm;

import com.practice.math.model.Club;
import com.practice.math.model.Game;
import com.practice.math.model.Result;
import com.practice.math.utils.MatchWeights;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FuzzyRules {
    private Club firstClub;
    private Club secondClub;
    private List<Game> firstClubGames;
    private List<Game> secondClubGames;
    private Result result;

    private double firstRate;
    private double secondRate;

    private double firstPositionRate;
    private double secondPositionRate;
    private double firstInjuresRate;
    private double secondInjuresRate;
    private double firstGoalsRate;
    private double secondGoalsRate;
    private double firstFieldRate;
    private double secondFieldRate;


    public FuzzyRules(Club firstClub, Club secondClub, List<Game> firstClubGames, List<Game> secondClubGames, Result result) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
        this.firstClubGames = firstClubGames;
        this.secondClubGames = secondClubGames;
        this.result = result;
        calculatePositionRates();
        calculateInjuresRates();
        calculateGoalsRates();
        calculateFieldRates();
        calculateRates();
    }

    private void calculatePositionRates() {
        if (firstClub.getPosition() - secondClub.getPosition() == 0) {
            firstPositionRate += 0.5 * MatchWeights.POSITION.getValue();
            secondPositionRate += 0.5 * MatchWeights.POSITION.getValue();
        } else if (firstClub.getPosition() - secondClub.getPosition() > 3) {
            firstPositionRate += 0.55 * MatchWeights.POSITION.getValue();
            secondPositionRate += 0.45 * MatchWeights.POSITION.getValue();
        } else if (secondClub.getPosition() - firstClub.getPosition() > 3) {
            secondPositionRate += 0.55 * MatchWeights.POSITION.getValue();
            firstPositionRate += 0.45 * MatchWeights.POSITION.getValue();
        } else if (firstClub.getPosition() - secondClub.getPosition() > 6) {
            firstPositionRate += 0.6 * MatchWeights.POSITION.getValue();
            secondPositionRate += 0.4 * MatchWeights.POSITION.getValue();
        } else if (secondClub.getPosition() - firstClub.getPosition() > 6) {
            secondPositionRate += 0.6 * MatchWeights.POSITION.getValue();
            firstPositionRate += 0.4 * MatchWeights.POSITION.getValue();
        } else if (firstClub.getPosition() - secondClub.getPosition() > 9) {
            firstRate += 0.65 * MatchWeights.POSITION.getValue();
            secondRate += 0.35 * MatchWeights.POSITION.getValue();
        } else if (secondClub.getPosition() - firstClub.getPosition() > 9) {
            secondRate += 0.65 * MatchWeights.POSITION.getValue();
            firstRate += 0.35 * MatchWeights.POSITION.getValue();
        }
    }

    private void calculateInjuresRates() {
        if (result.getFirstInjures() - result.getSecondInjures() == 0) {
            firstInjuresRate += 0.5 * MatchWeights.INJURES.getValue();
            secondInjuresRate += 0.5 * MatchWeights.INJURES.getValue();
        } else if (result.getFirstInjures() - result.getSecondInjures() < 2) {
            firstInjuresRate += 0.55 * MatchWeights.INJURES.getValue();
            secondInjuresRate += 0.45 * MatchWeights.INJURES.getValue();
        } else if (result.getSecondInjures() - result.getFirstInjures() < 2) {
            secondInjuresRate += 0.45 * MatchWeights.INJURES.getValue();
            firstInjuresRate += 0.55 * MatchWeights.INJURES.getValue();
        } else if (result.getFirstInjures() - result.getSecondInjures() < 4) {
            firstInjuresRate += 0.6 * MatchWeights.INJURES.getValue();
            secondInjuresRate += 0.4 * MatchWeights.INJURES.getValue();
        } else if (result.getSecondInjures() - result.getFirstInjures() < 4) {
            secondInjuresRate += 0.6 * MatchWeights.INJURES.getValue();
            firstInjuresRate += 0.4 * MatchWeights.INJURES.getValue();
        } else if (result.getFirstInjures() - result.getSecondInjures() < 6) {
            firstInjuresRate += 0.65 * MatchWeights.INJURES.getValue();
            secondInjuresRate += 0.35 * MatchWeights.INJURES.getValue();
        } else if (result.getSecondInjures() - result.getFirstInjures() < 6) {
            secondInjuresRate += 0.65 * MatchWeights.INJURES.getValue();
            firstInjuresRate += 0.35 * MatchWeights.INJURES.getValue();
        }
    }

    private void calculateGoalsRates() {
        for (Game game : firstClubGames) {
            if (game.getFirstClub().equals(firstClub.getName())) {
                firstGoalsRate += game.getFirstGoals();

            } else {
                firstGoalsRate += game.getSecondGoals();
            }
        }
        for (Game game : secondClubGames) {
            if (game.getFirstClub().equals(secondClub.getName())) {
                secondGoalsRate += game.getFirstGoals();
            } else {
                secondGoalsRate += game.getSecondGoals();
            }
        }

        if (firstGoalsRate - secondGoalsRate == 0) {
            firstGoalsRate += 0.5 * MatchWeights.SCORE.getValue();
            secondGoalsRate += 0.5 * MatchWeights.SCORE.getValue();
        } else if (firstGoalsRate - secondGoalsRate > 3) {
            firstGoalsRate += 0.55 * MatchWeights.SCORE.getValue();
            secondGoalsRate += 0.45 * MatchWeights.SCORE.getValue();
        } else if (secondGoalsRate - firstGoalsRate > 3) {
            secondGoalsRate += 0.55 * MatchWeights.SCORE.getValue();
            firstGoalsRate += 0.45 * MatchWeights.SCORE.getValue();
        } else if (firstGoalsRate - secondGoalsRate > 6) {
            firstInjuresRate += 0.6 * MatchWeights.SCORE.getValue();
            secondInjuresRate += 0.4 * MatchWeights.SCORE.getValue();
        } else if (secondGoalsRate - firstGoalsRate > 6) {
            secondGoalsRate += 0.6 * MatchWeights.SCORE.getValue();
            firstGoalsRate += 0.4 * MatchWeights.SCORE.getValue();
        } else if (firstGoalsRate - secondGoalsRate > 9) {
            firstInjuresRate += 0.65 * MatchWeights.SCORE.getValue();
            secondInjuresRate += 0.4 * MatchWeights.SCORE.getValue();
        } else if (secondGoalsRate - firstGoalsRate > 9) {
            secondGoalsRate += 0.6 * MatchWeights.SCORE.getValue();
            firstGoalsRate += 0.35 * MatchWeights.SCORE.getValue();
        }
    }

    private void calculateFieldRates() {
        double sumPoints = 0;
        double matches = 0;

        for (Game game : firstClubGames) {
            if (game.getFirstClub().equals(firstClub.getName())) {
                if (game.getFirstGoals() > game.getSecondGoals()) {
                    sumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    sumPoints += 1;
                } else {
                    sumPoints += 0;
                }
                matches++;
            }
        }
        if (sumPoints / matches > 0) {
            firstFieldRate = 0.5 * MatchWeights.HOME.getValue();
        } else if (sumPoints / matches > 1) {
            firstFieldRate = 0.6 * MatchWeights.HOME.getValue();
        } else if (sumPoints / matches > 2) {
            firstFieldRate = 0.7 * MatchWeights.HOME.getValue();
        }

        sumPoints = 0;
        matches = 0;
        for (Game game : firstClubGames) {
            if (game.getSecondClub().equals(secondClub.getName())) {
                if (game.getFirstGoals() < game.getSecondGoals()) {
                    sumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    sumPoints += 1;
                } else {
                    sumPoints += 0;
                }
                matches++;
            }
        }
        if (sumPoints / matches > 0) {
            secondFieldRate = 0.5 * MatchWeights.HOME.getValue();
        } else if (sumPoints / matches > 1) {
            secondFieldRate = 0.6 * MatchWeights.HOME.getValue();
        } else if (sumPoints / matches > 2) {
            secondFieldRate = 0.7 * MatchWeights.HOME.getValue();
        }
    }

    private void calculateRates() {
        double overallFirstRate = firstFieldRate + firstGoalsRate + firstInjuresRate + firstPositionRate;
        double overallSecondRate = secondFieldRate + secondGoalsRate + secondInjuresRate + secondPositionRate;
        firstRate = overallFirstRate / (overallFirstRate + overallSecondRate);
        secondRate = overallSecondRate / (overallFirstRate + overallSecondRate);
    }

    public double getFirstRate() {
        return new BigDecimal(firstRate * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getSecondRate() {
        return new BigDecimal(secondRate * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
