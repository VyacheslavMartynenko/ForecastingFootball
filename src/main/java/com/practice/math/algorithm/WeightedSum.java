package com.practice.math.algorithm;

import com.practice.math.model.Club;
import com.practice.math.model.Game;
import com.practice.math.model.Result;
import com.practice.math.utils.MatchWeights;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WeightedSum {
    private Club firstClub;
    private Club secondClub;
    private List<Game> firstClubGames;
    private List<Game> secondClubGames;
    private Result result;
    private List<Double> firstClubValues;
    private List<Double> secondClubValues;
    private List<MatchWeights> matchWeights;

    private double firstRate;
    private double secondRate;

    private double firstSumPoints;
    private double firstSumScore;
    private double firstSumMiss;
    private double secondSumPoints;
    private double secondSumScore;
    private double secondSumMiss;

    private double firstAverageShoots;
    private double firstAverageShootsTarget;
    private double firstAveragePasses;
    private double firstAveragePassesTarget;
    private double firstAverageCorners;
    private double firstAverageDuels;
    private double firstAveragePossession;
    private double secondAverageShoots;
    private double secondAverageShootsTarget;
    private double secondAveragePasses;
    private double secondAveragePassesTarget;
    private double secondAverageCorners;
    private double secondAverageDuels;
    private double secondAveragePossession;


    public WeightedSum(Club firstClub, Club secondClub, List<Game> firstClubGames, List<Game> secondClubGames, Result result) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
        this.firstClubGames = firstClubGames;
        this.secondClubGames = secondClubGames;
        this.result = result;
        firstClubValues = new ArrayList<>();
        secondClubValues = new ArrayList<>();
        matchWeights = new ArrayList<>();
        calculateRelativeWeights();
        addWeights();
        addFirstClubRelativeWeights();
        addSecondClubRelativeWeights();
        calculateRelativeRates();
    }

    private double calculateRelativeWeight(double firstValue, double secondValue) {
        return firstValue / (firstValue + secondValue);
    }

    private void calculateRelativeWeights() {
        for (Game game : firstClubGames) {
            if (game.getFirstClub().equals(firstClub.getName())) {
                firstSumScore += game.getFirstGoals();
                firstSumMiss += game.getSecondGoals();
                if (game.getFirstGoals() > game.getSecondGoals()) {
                    firstSumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    firstSumPoints += 1;
                } else {
                    firstSumPoints += 0;
                }
                firstAverageShoots += game.getFirstShoots();
                firstAverageShootsTarget += game.getFirstShootsTarget();
                firstAveragePasses += game.getFirstPasses();
                firstAveragePassesTarget += game.getFirstPassesTarget();
                firstAverageCorners += game.getFirstCorners();
                firstAverageDuels += game.getFirstDuels();
                firstAveragePossession += game.getFirstPossession();
            } else {
                firstSumScore += game.getSecondGoals();
                firstSumMiss += game.getFirstGoals();
                if (game.getFirstGoals() < game.getSecondGoals()) {
                    firstSumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    firstSumPoints += 1;
                } else {
                    firstSumPoints += 0;
                }
                firstAverageShoots += game.getSecondShoots();
                firstAverageShootsTarget += game.getSecondShootsTarget();
                firstAveragePasses += game.getSecondPasses();
                firstAveragePassesTarget += game.getSecondPassesTarget();
                firstAverageCorners += game.getSecondCorners();
                firstAverageDuels += game.getSecondDuels();
                firstAveragePossession += game.getSecondPossession();
            }
        }
        firstAverageShoots = firstAverageShoots / firstClubGames.size();
        firstAverageShootsTarget = firstAverageShootsTarget / firstClubGames.size();
        firstAveragePasses = firstAveragePasses / firstClubGames.size();
        firstAveragePassesTarget = firstAveragePassesTarget / firstClubGames.size();
        firstAverageCorners = firstAverageCorners / firstClubGames.size();
        firstAverageDuels = firstAverageDuels / firstClubGames.size();
        firstAveragePossession = firstAveragePossession / firstClubGames.size();

        for (Game game : secondClubGames) {
            if (game.getFirstClub().equals(secondClub.getName())) {
                secondSumScore += game.getFirstGoals();
                secondSumMiss += game.getSecondGoals();
                if (game.getFirstGoals() > game.getSecondGoals()) {
                    firstSumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    firstSumPoints += 1;
                } else {
                    firstSumPoints += 0;
                }
                secondAverageShoots += game.getFirstShoots();
                secondAverageShootsTarget += game.getFirstShootsTarget();
                secondAveragePasses += game.getFirstPasses();
                secondAveragePassesTarget += game.getFirstPassesTarget();
                secondAverageCorners += game.getFirstCorners();
                secondAverageDuels += game.getFirstDuels();
                secondAveragePossession += game.getFirstPossession();
            } else {
                secondSumScore += game.getSecondGoals();
                secondSumMiss += game.getFirstGoals();
                if (game.getFirstGoals() < game.getSecondGoals()) {
                    firstSumPoints += 3;
                } else if (game.getFirstGoals() == game.getSecondGoals()) {
                    firstSumPoints += 1;
                } else {
                    firstSumPoints += 0;
                }
                secondAverageShoots += game.getSecondShoots();
                secondAverageShootsTarget += game.getSecondShootsTarget();
                secondAveragePasses += game.getSecondPasses();
                secondAveragePassesTarget += game.getSecondPassesTarget();
                secondAverageCorners += game.getSecondCorners();
                secondAverageDuels += game.getSecondDuels();
                secondAveragePossession += game.getSecondPossession();
            }
        }
        secondAverageShoots = secondAverageShoots / secondClubGames.size();
        secondAverageShootsTarget = secondAverageShootsTarget / secondClubGames.size();
        secondAveragePasses = secondAveragePasses / secondClubGames.size();
        secondAveragePassesTarget = secondAveragePassesTarget / secondClubGames.size();
        secondAverageCorners = secondAverageCorners / secondClubGames.size();
        secondAverageDuels = secondAverageDuels / secondClubGames.size();
        secondAveragePossession = secondAveragePossession / secondClubGames.size();
    }

    private void addWeights() {
        matchWeights.add(MatchWeights.POSITION);
        matchWeights.add(MatchWeights.POINTS);
        matchWeights.add(MatchWeights.SCORE);
        matchWeights.add(MatchWeights.MISS);
        matchWeights.add(MatchWeights.SHOOT);
        matchWeights.add(MatchWeights.SHOOT_TARGET);
        matchWeights.add(MatchWeights.PASS);
        matchWeights.add(MatchWeights.PASS_TARGET);
        matchWeights.add(MatchWeights.CORNERS);
        matchWeights.add(MatchWeights.DUELS);
        matchWeights.add(MatchWeights.POSSESSION);
        matchWeights.add(MatchWeights.INJURES);
        matchWeights.add(MatchWeights.REST);
        matchWeights.add(MatchWeights.SHOOT_SERIES);
        matchWeights.add(MatchWeights.MISS_SERIES);
        matchWeights.add(MatchWeights.HOME);
    }

    private void addFirstClubRelativeWeights() {
        firstClubValues.add(calculateRelativeWeight(firstClub.getPosition(), secondClub.getPosition()));
        firstClubValues.add(calculateRelativeWeight(firstSumPoints, secondSumPoints));
        firstClubValues.add(calculateRelativeWeight(firstSumScore, secondSumScore));
        firstClubValues.add(calculateRelativeWeight(firstSumMiss, secondSumMiss));
        firstClubValues.add(calculateRelativeWeight(firstAverageShoots, secondAverageShoots));
        firstClubValues.add(calculateRelativeWeight(firstAverageShootsTarget, secondAverageShootsTarget));
        firstClubValues.add(calculateRelativeWeight(firstAveragePasses, secondAveragePasses));
        firstClubValues.add(calculateRelativeWeight(firstAveragePassesTarget, secondAverageShootsTarget));
        firstClubValues.add(calculateRelativeWeight(firstAverageCorners, secondAverageCorners));
        firstClubValues.add(calculateRelativeWeight(firstAverageDuels, secondAverageDuels));
        firstClubValues.add(calculateRelativeWeight(firstAveragePossession, secondAveragePossession));
        firstClubValues.add(calculateRelativeWeight(result.getFirstInjures(), result.getSecondInjures()));
        firstClubValues.add(calculateRelativeWeight(result.getFirstRest(), result.getSecondRest()));
        firstClubValues.add(calculateRelativeWeight(result.getFirstAttack(), result.getSecondAttack()));
        firstClubValues.add(calculateRelativeWeight(result.getFirstDefence(), result.getSecondDefence()));
        firstClubValues.add(calculateRelativeWeight(1, 0));
    }

    private void addSecondClubRelativeWeights() {
        secondClubValues.add(calculateRelativeWeight(secondClub.getPosition(), firstClub.getPosition()));
        secondClubValues.add(calculateRelativeWeight(secondSumPoints, firstSumPoints));
        secondClubValues.add(calculateRelativeWeight(secondSumScore, firstSumScore));
        secondClubValues.add(calculateRelativeWeight(secondSumMiss, firstSumMiss));
        secondClubValues.add(calculateRelativeWeight(secondAverageShoots, firstAverageShoots));
        secondClubValues.add(calculateRelativeWeight(secondAverageShootsTarget, firstAverageShootsTarget));
        secondClubValues.add(calculateRelativeWeight(secondAveragePasses, firstAveragePasses));
        secondClubValues.add(calculateRelativeWeight(secondAverageShootsTarget, firstAveragePassesTarget));
        secondClubValues.add(calculateRelativeWeight(secondAverageCorners, firstAverageCorners));
        secondClubValues.add(calculateRelativeWeight(secondAverageDuels, firstAverageDuels));
        secondClubValues.add(calculateRelativeWeight(secondAveragePossession, firstAveragePossession));
        secondClubValues.add(calculateRelativeWeight(result.getSecondInjures(), result.getFirstInjures()));
        secondClubValues.add(calculateRelativeWeight(result.getSecondRest(), result.getFirstRest()));
        secondClubValues.add(calculateRelativeWeight(result.getSecondAttack(), result.getFirstAttack()));
        secondClubValues.add(calculateRelativeWeight(result.getSecondDefence(), result.getFirstDefence()));
        secondClubValues.add(calculateRelativeWeight(0, 1));
    }

    private void calculateRelativeRates() {
        double firstRateSum = 0;
        double secondRateSum = 0;
        for (int i = 0; i < matchWeights.size(); i++) {
            firstRateSum += matchWeights.get(i).getValue() * firstClubValues.get(i);
            secondRateSum += matchWeights.get(i).getValue() * secondClubValues.get(i);
        }
        firstRate = firstRateSum /(firstRateSum + secondRateSum);
        secondRate = secondRateSum / (firstRateSum + secondRateSum);
    }

    public double getFirstRate() {
        return new BigDecimal(firstRate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getSecondRate() {
        return new BigDecimal(secondRate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
