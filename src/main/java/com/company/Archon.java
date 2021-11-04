package com.company;


import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

public enum Archon {
    BRAVE(0),
    STREAMY(1),
    WISE(2),
    GREAT(3);

    @Getter
    private int code;

    Archon(int code) {
        this.code = code;
    }

    public static Archon randomType(){
        switch (ThreadLocalRandom.current().nextInt(values().length)){
            case 0:
                return Archon.BRAVE;
            case 1:
                return Archon.STREAMY;
            case 2:
                return Archon.WISE;
            default:
                return Archon.GREAT;
        }
    }
}
