package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList();
        for (int i = 0; i < 15; i++)
            characters.add(Character.builder().build());

        System.out.println("Персонаж с максимальным количеством hp");
        System.out.println(characters.stream().max(Comparator.comparing(Character::getHp)).orElseThrow());
        System.out.println();

        System.out.println("Персонаж с минимальным количеством hp");
        System.out.println(characters.stream().min(Comparator.comparing(Character::getHp)).orElseThrow());
        System.out.println();

        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого меньше 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() < 100).forEach(System.out::println);
        System.out.println();

        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого больше или равно 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() >= 100).forEach(System.out::println);
        System.out.println();

        System.out.println("Выборка по рандомному типу архонта, умножить произольную характеристику на 2");
        System.out.println("Собрать выборку в List, вывести");
        int multiplier = 2;
        Archon archon = Archon.randomType();
        List<Character> sameArchoncharacters = characters.stream().filter(ch -> ch.getArchon() == archon).peek(ch -> {
                switch (ThreadLocalRandom.current().nextInt(5)){
                    case 0:
                        ch.setHp(ch.getHp() * multiplier);
                        break;
                    case 1:
                        ch.setAtk(ch.getAtk() * multiplier);
                        break;
                    case 2:
                        ch.setElementsMastery(ch.getElementsMastery() * multiplier);
                        break;
                    case 3:
                        ch.setEndurance(ch.getEndurance() * multiplier);
                        break;
                    default:
                        ch.setCriticalHitChance(ch.getCriticalHitChance() * multiplier);
                }
        }).collect(Collectors.toList());
        for (Character character:sameArchoncharacters)
            System.out.println(character);
        System.out.println();

        System.out.println("Найти персонажа со значением характеристики силы атаки в 1337, поместить в Optional,");
        System.out.println("Если объект существует, то вывести 133t, иначе No 133t");
        int requiredHp = 1337;
        Optional<Character> character = characters.stream().filter(ch -> ch.getAtk() == requiredHp).findAny();
        character.ifPresentOrElse(ch -> System.out.println("133t " +  ch), () -> System.out.println("No 133t"));
        System.out.println();

        System.out.println("Посчитать для каждой специализации количество персонажей. Вывести");
        for (Archon arch: Archon.values()) {
            System.out.println(arch);
            characters.stream().filter(ch -> ch.getArchon() == arch).forEach(System.out::println);
            System.out.println();
        }
    }
}
