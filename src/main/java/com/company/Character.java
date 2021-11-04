package com.company;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@Builder
public class Character {

    @Builder.Default
    int hp = ThreadLocalRandom.current().nextInt(Constants.MIN_HP.getPoints(), Constants.MAX_HP.getPoints());

    @Builder.Default
    int atk = ThreadLocalRandom.current().nextInt(Constants.MIN_ATK.getPoints(), Constants.MAX_ATK.getPoints());

    @Builder.Default
    int elementsMastery = ThreadLocalRandom.current().nextInt(Constants.MIN_ELEMENTS_MASTERY.getPoints(), Constants.MAX_ELEMENTS_MASTERY.getPoints());

    @Builder.Default
    int endurance = ThreadLocalRandom.current().nextInt(Constants.MIN_INDURANCE.getPoints(), Constants.MAX_INDURANCE.getPoints());

    @Builder.Default
    Archon archon = Archon.randomType();

    @Builder.Default
    int criticalHitChance = ThreadLocalRandom.current().nextInt(Constants.MIN_CRITICAL_HIT_CHANCE.getPoints(), Constants.MAX_CRITICAL_HIT_CHANCE.getPoints());
}
