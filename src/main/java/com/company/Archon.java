package com.company;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

public enum Archon {
    BRAVE(Constants.ARCHON_BRAVE_CODE.getPoints()),
    STREAMY(Constants.ARCHON_STREAMY_CODE.getPoints()),
    WISE(Constants.ARCHON_WISE_CODE.getPoints()),
    GREAT(Constants.ARCHON_GREAT_CODE.getPoints());

    @Getter
    private final int code;

    Archon(int code) {
        this.code = code;
    }

    public static Archon randomType(){
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
}
