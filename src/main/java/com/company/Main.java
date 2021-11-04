package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> characters = newRandomCharacters();
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

    public static ArrayList<Character> newRandomCharacters(){
        int charactersAmmount = 15;
        ArrayList<Character> characters = new ArrayList();
        for (int i = 0; i < charactersAmmount; i++)
            characters.add(Character.builder().build());
        return characters;
    }

    public static void taskA(ArrayList<Character> characters){
        System.out.println("Персонаж с максимальным количеством hp");
        System.out.println(characters.stream().max(Comparator.comparing(Character::getHp)).orElseThrow());
    }

    public static void taskB(ArrayList<Character> characters){
        System.out.println("Персонаж с минимальным количеством hp");
        System.out.println(characters.stream().min(Comparator.comparing(Character::getHp)).orElseThrow());
    }

    public static void taskC(ArrayList<Character> characters){
        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого меньше 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() < 100).forEach(System.out::println);
    }

    public static void taskD(ArrayList<Character> characters){
        System.out.println("Сортировать персонажей по силе атаки, выбрать только тех, у кого больше или равно 100");
        characters.stream().sorted(Comparator.comparing(Character::getHp)).filter(ch -> ch.getHp() >= 100).forEach(System.out::println);
    }

    public static void taskE(ArrayList<Character> characters){
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

    public static void taskF(ArrayList<Character> characters){
        System.out.println("Найти персонажа со значением характеристики силы атаки в 1337.");
        System.out.println("Если объект существует, то вывести 133t и персонажа, иначе No 133t.");
        int requiredHp = 1337;
        characters.stream().filter(ch -> ch.getAtk() == requiredHp).findAny().ifPresentOrElse((ch -> System.out.println("133t " +  ch)), () -> System.out.println("No 133t"));
    }

    public static void taskG(ArrayList<Character> characters){
        System.out.println("Посичтать для каждой специализации количество персонажий. Посчитать, вывести.");
        Arrays.stream(Archon.values()).forEach(archon -> {
            System.out.println(archon + " - " + characters.stream().filter(ch -> ch.getArchon() == archon).count());
            characters.stream().filter(ch -> ch.getArchon() == archon).forEach(System.out::println);
        });
    }
}
