package com.practice.math.utils;

public enum MatchWeights {
    POSITION(4), POINTS(5), SCORE(5), MISS(5),
    SHOOT(4), SHOOT_TARGET(5), PASS(3), PASS_TARGET(5),
    CORNERS(5), DUELS(4), POSSESSION(3), INJURES(5), REST(4),
    SHOOT_SERIES(5), MISS_SERIES(5), HOME(1);

    private final int value;

    MatchWeights(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
