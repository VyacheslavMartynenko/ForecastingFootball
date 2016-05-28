package com.practice.math.utils;

public enum MatchWeights {
    POSITION(6), POINTS(9), SCORE(7), MISS(7),
    SHOOT(4), SHOOT_TARGET(7), PASS(3), PASS_TARGET(5),
    CORNERS(7), DUELS(4), POSSESSION(3), INJURES(5), REST(4),
    SHOOT_SERIES(5), MISS_SERIES(5), HOME(7);

    private final int value;

    MatchWeights(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
