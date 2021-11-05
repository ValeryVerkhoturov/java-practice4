package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Character> characters = newRandomCharacters();
        
        taskA(characters);
        System.out.println();
        
        taskB(characters);
        System.out.println();
        
        taskC(characters);
        System.out.println();
        
        taskD(characters);
        System.out.println();
        
        taskE(characters);
        System.out.println();
        
        taskF(characters);
        System.out.println();
        
        taskG(characters);
    }

    public static List<Character> newRandomCharacters(){
        int charactersAmmount = 15;
        return IntStream.range(0, charactersAmmount).mapToObj(i -> Character.builder().build()).collect(Collectors.toList());
    }

    public static void taskA(List<Character> characters){
        System.out.println("Персонаж с максимальным количеством hp");
        System.out.println(characters.stream().max(Comparator.comparing(Character::getHp)).orElseThrow());
    }

    public static void taskB(List<Character> characters){
        System.out.println("Персонаж с минимальным количеством hp");
        System.out.println(characters.stream().min(Comparator.comparing(Character::getHp)).orElseThrow());
    }

    public static void taskC(List<Character> characters){
        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого меньше 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() < 100).forEach(System.out::println);
    }

    public static void taskD(List<Character> characters){
        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого больше или равно 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() >= 100).forEach(System.out::println);
    }

    public static void taskE(List<Character> characters){
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
        sameArchoncharacters.forEach(System.out::println);
    }

    public static void taskF(List<Character> characters){
        System.out.println("Найти персонажа со значением характеристики силы атаки в 1337.");
        System.out.println("Если объект существует, то вывести 133t и персонажа, иначе No 133t.");
        int requiredHp = 1337;
        characters.stream().filter(ch -> ch.getAtk() == requiredHp).findAny().ifPresentOrElse((ch -> System.out.println("133t " +  ch)), () -> System.out.println("No 133t"));
    }

    public static void taskG(List<Character> characters){
        System.out.println("Посичтать для каждой специализации количество персонажий. Посчитать, вывести.");
        Arrays.stream(Archon.values()).forEach(archon -> {
            System.out.println(archon + " - " + characters.stream().filter(ch -> ch.getArchon() == archon).count());
            characters.stream().filter(ch -> ch.getArchon() == archon).forEach(System.out::println);
        });
    }
}

/*
Персонаж с максимальным количеством hp
Character(hp=1482, atk=129, elementsMastery=3, endurance=6, archon=BRAVE, criticalHitChance=14)

Персонаж с минимальным количеством hp
Character(hp=185, atk=128, elementsMastery=11, endurance=22, archon=BRAVE, criticalHitChance=17)

Сортировать персонажей по силе атаки, выбрать только тех, у кого меньше 100

Сортировать персонажей по силе атаки, выбрать только тех, у кого больше или равно 100
Character(hp=185, atk=128, elementsMastery=11, endurance=22, archon=BRAVE, criticalHitChance=17)
Character(hp=390, atk=100, elementsMastery=3, endurance=46, archon=STREAMY, criticalHitChance=11)
Character(hp=434, atk=123, elementsMastery=19, endurance=15, archon=BRAVE, criticalHitChance=3)
Character(hp=495, atk=177, elementsMastery=14, endurance=18, archon=BRAVE, criticalHitChance=15)
Character(hp=677, atk=109, elementsMastery=11, endurance=94, archon=GREAT, criticalHitChance=19)
Character(hp=702, atk=189, elementsMastery=13, endurance=66, archon=BRAVE, criticalHitChance=13)
Character(hp=722, atk=137, elementsMastery=2, endurance=70, archon=GREAT, criticalHitChance=5)
Character(hp=825, atk=165, elementsMastery=9, endurance=91, archon=STREAMY, criticalHitChance=13)
Character(hp=916, atk=180, elementsMastery=10, endurance=73, archon=WISE, criticalHitChance=18)
Character(hp=998, atk=136, elementsMastery=12, endurance=70, archon=STREAMY, criticalHitChance=12)
Character(hp=1022, atk=151, elementsMastery=3, endurance=57, archon=WISE, criticalHitChance=18)
Character(hp=1104, atk=174, elementsMastery=14, endurance=37, archon=GREAT, criticalHitChance=7)
Character(hp=1107, atk=179, elementsMastery=18, endurance=52, archon=STREAMY, criticalHitChance=9)
Character(hp=1188, atk=124, elementsMastery=6, endurance=20, archon=GREAT, criticalHitChance=13)
Character(hp=1482, atk=129, elementsMastery=3, endurance=6, archon=BRAVE, criticalHitChance=14)

Выборка по рандомному типу архонта, умножить произольную характеристику на 2
Собрать выборку в List, вывести
Character(hp=390, atk=100, elementsMastery=6, endurance=46, archon=STREAMY, criticalHitChance=11)
Character(hp=1107, atk=179, elementsMastery=18, endurance=104, archon=STREAMY, criticalHitChance=9)
Character(hp=825, atk=165, elementsMastery=9, endurance=182, archon=STREAMY, criticalHitChance=13)
Character(hp=998, atk=272, elementsMastery=12, endurance=70, archon=STREAMY, criticalHitChance=12)

Найти персонажа со значением характеристики силы атаки в 1337.
Если объект существует, то вывести 133t и персонажа, иначе No 133t.
No 133t

Посичтать для каждой специализации количество персонажий. Посчитать, вывести.
BRAVE - 5
Character(hp=434, atk=123, elementsMastery=19, endurance=15, archon=BRAVE, criticalHitChance=3)
Character(hp=702, atk=189, elementsMastery=13, endurance=66, archon=BRAVE, criticalHitChance=13)
Character(hp=1482, atk=129, elementsMastery=3, endurance=6, archon=BRAVE, criticalHitChance=14)
Character(hp=185, atk=128, elementsMastery=11, endurance=22, archon=BRAVE, criticalHitChance=17)
Character(hp=495, atk=177, elementsMastery=14, endurance=18, archon=BRAVE, criticalHitChance=15)
STREAMY - 4
Character(hp=390, atk=100, elementsMastery=6, endurance=46, archon=STREAMY, criticalHitChance=11)
Character(hp=1107, atk=179, elementsMastery=18, endurance=104, archon=STREAMY, criticalHitChance=9)
Character(hp=825, atk=165, elementsMastery=9, endurance=182, archon=STREAMY, criticalHitChance=13)
Character(hp=998, atk=272, elementsMastery=12, endurance=70, archon=STREAMY, criticalHitChance=12)
WISE - 2
Character(hp=916, atk=180, elementsMastery=10, endurance=73, archon=WISE, criticalHitChance=18)
Character(hp=1022, atk=151, elementsMastery=3, endurance=57, archon=WISE, criticalHitChance=18)
GREAT - 4
Character(hp=1188, atk=124, elementsMastery=6, endurance=20, archon=GREAT, criticalHitChance=13)
Character(hp=722, atk=137, elementsMastery=2, endurance=70, archon=GREAT, criticalHitChance=5)
Character(hp=677, atk=109, elementsMastery=11, endurance=94, archon=GREAT, criticalHitChance=19)
Character(hp=1104, atk=174, elementsMastery=14, endurance=37, archon=GREAT, criticalHitChance=7)
 */
