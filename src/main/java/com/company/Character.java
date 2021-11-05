package com.company;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@RequiredArgsConstructor
@Builder(builderMethodName = "randomBuilder")
public class Character {

    @Builder.Default @NonNull
    int hp = ThreadLocalRandom.current().nextInt(Constants.MIN_HP.getPoints(), Constants.MAX_HP.getPoints());

    @Builder.Default @NonNull
    int atk = ThreadLocalRandom.current().nextInt(Constants.MIN_ATK.getPoints(), Constants.MAX_ATK.getPoints());

    @Builder.Default @NonNull
    int elementsMastery = ThreadLocalRandom.current().nextInt(Constants.MIN_ELEMENTS_MASTERY.getPoints(), Constants.MAX_ELEMENTS_MASTERY.getPoints());

    @Builder.Default @NonNull
    int endurance = ThreadLocalRandom.current().nextInt(Constants.MIN_INDURANCE.getPoints(), Constants.MAX_INDURANCE.getPoints());

    @Builder.Default @NonNull
    Archon archon = Archon.randomType();

    @Builder.Default @NonNull
    int criticalHitChance = ThreadLocalRandom.current().nextInt(Constants.MIN_CRITICAL_HIT_CHANCE.getPoints(), Constants.MAX_CRITICAL_HIT_CHANCE.getPoints());
}
