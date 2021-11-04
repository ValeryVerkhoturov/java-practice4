package com.company;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@Builder
public class Character {

    @Builder.Default
    int hp = ThreadLocalRandom.current().nextInt(1500) + 1;

    @Builder.Default
    int atk = ThreadLocalRandom.current().nextInt(20);

    @Builder.Default
    int elementsMastery = ThreadLocalRandom.current().nextInt(20);

    @Builder.Default
    int endurance = ThreadLocalRandom.current().nextInt(20);

    @Builder.Default
    Archon archon = Archon.randomType();

    @Builder.Default
    int criticalHitChance = ThreadLocalRandom.current().nextInt(20);
}
