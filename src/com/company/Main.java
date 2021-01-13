package com.company;

import java.util.Scanner;

public class Main {

    /**Наполнение сцены*/
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String carlsonName = read.nextLine();

        WelfareCalculating calculate;
        calculate = (moodLevel, weight, numberOfSweets) -> (Math.pow(moodLevel, 2) + Math.pow(numberOfSweets, 2)/weight)*Math.pow(weight, -0.5);

        AmountOfSweets onepiece = AmountOfSweets.ONEPIECE;
        AmountOfSweets bag = AmountOfSweets.BAG;
        AmountOfSweets box = AmountOfSweets.BOX;

        Carlson carlson = null;
        Kirre kirre = null;
        Gunilla gunilla = null;
        Malish malish = null;

        try {
            carlson = new Carlson(carlsonName, "мальчик", 70, 100, onepiece, 2, 2);
            kirre = new Kirre("Кирре", "мальчик", 30, 50, bag, 0, 2);
            gunilla = new Gunilla("Гунилла", "девочка", 40,40, box, 1);
            malish = new Malish("Малыш", "мальчик", 30, 40, bag, 5, 5);
        } catch (WrongInputException e) {
            System.err.println(e.getMessage());
        }

        Malish.Puppy alberg = new Malish.Puppy("Альберг", 10, 0, 2);

        Character[] stageParticipants = new Character[3];
        stageParticipants[0] = carlson; carlson.setArrayIndex(0);
        stageParticipants[1] = kirre; kirre.setArrayIndex(1);
        stageParticipants[2] = gunilla; gunilla.setArrayIndex(2);

        class KristerAndOther implements Retiring {
            private int arrayIndex;
            @Override
            public void gone() {
                System.out.println("Кристер и другие дети тоже ушли" + leavingMood());
            }

            @Override
            public String leavingMood() {
                return " не оставив подарков";
            }
        };
        KristerAndOther kristerAndOther = new KristerAndOther();



        kirre.addSweets(2);
        gunilla.addSweets(1);



        int albergWeight = alberg.getWeight();
        carlson.addWeight(albergWeight);
        int carlsonNewPosition = carlson.moveToPosition(5, alberg);
        System.out.println(carlson.getName() + " вернул " + alberg.getName() + " на землю");
        carlson.removeWeight(albergWeight);
        if(carlsonNewPosition == malish.getPosition()) System.out.println(alberg.getName() + " оказался рядом с " + malish.getName());
        alberg.buckUp();



        try {
            kirre.exchangeSweetsFromTo(kirre, carlson, bag);
        } catch (ImpossibleValueException e) {
            System.err.println(e.getMessage());
        }

        try {
            gunilla.exchangeSweetsFromTo(gunilla, carlson, box);
        } catch (ImpossibleValueException e) {
            System.err.println(e.getMessage());
        }
        gunilla.thinkAbout(carlson);

        try {
            carlson.share(kirre, gunilla, carlson, bag);
        } catch (ImpossibleValueException e) {
            System.err.println(e.getMessage());
        }



        String conclusion = gunilla.makeConclusion(carlson);
        System.out.println(conclusion);
        String carlsonResponse = carlson.takeOffence(conclusion);
        System.out.println(carlsonResponse);
        kirre.showAgress(carlsonResponse, carlson);
        double gunillaWelfare = calculate.calculateWelfare(gunilla.getMoodLevel(), gunilla.getWeight(), gunilla.getNumberOfSweets());
        gunilla.cry(gunillaWelfare);



        kristerAndOther.gone();

        for(Character character : stageParticipants) {
            ((Retiring)character).gone();
            stageParticipants[character.getArrayIndex()] = null;
            try {
                String leavingMessage = ((Retiring)character).leaveGift(onepiece, malish, (Character)character);
                System.out.println(leavingMessage);
            } catch(ImpossibleValueException e) {
                System.err.println(e.getMessage());
            }
        }



        malish.areHappy(stageParticipants);
        malish.feed(alberg, onepiece);
        alberg.lick(malish);
        alberg.fallAsleep();



        System.out.println(carlson);
        System.out.println(kirre);
        System.out.println(gunilla);
        System.out.println(malish);
    }
}




