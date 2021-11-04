package com.company;

import lombok.Getter;

public enum Constants {

    MAX_HP(1500),
    MIN_HP(1),

    MAX_ATK(200),
    MIN_ATK(100),

    MAX_ELEMENTS_MASTERY(20),
    MIN_ELEMENTS_MASTERY(1),

    MAX_INDURANCE(100),
    MIN_INDURANCE(0),

    MAX_CRITICAL_HIT_CHANCE(20),
    MIN_CRITICAL_HIT_CHANCE(1),

    ARCHON_BRAVE_CODE(0),
    ARCHON_STREAMY_CODE(1),
    ARCHON_WISE_CODE(2),
    ARCHON_GREAT_CODE(3);

    @Getter
    private final int points;

    Constants(int points) {
        this.points = points;
    }
}
