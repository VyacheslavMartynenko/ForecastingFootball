package com.practice.math.algorithm;

import com.practice.math.model.Club;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class WeightedSum {
    private Club firstClub;
    private Club secondClub;

    public WeightedSum(Club firstClub, Club secondClub) {
        this.firstClub = firstClub;
        this.secondClub = secondClub;
    }

    public Club getFirstClub() {
        return firstClub;
    }

    public Club getSecondClub() {
        return secondClub;
    }

    public double calculateFirstRate(){
        Double rate = new Random().nextDouble();
        return new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calculateSecondRate(){
        Double rate = new Random().nextDouble();
        return new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
