package com.company;

public class FightForSweets implements ExchangingSweets {

    /**Персонажи, учатсвующие в бое*/
    Character giving;
    Character taking;

    /**Конструктор боя*/
    public FightForSweets(Character giving, Character taking) {
        this.taking = taking;
        this.giving = giving;
    }

    /**Определяет возможность ничьей*/
    private boolean isDraw(Character giving, Character taking) {
        if(taking.equals(giving)) return true;
        else return false;
    }

    /**Реализует бой между двумя персонажами*/
    public void start(Character giving, Character taking, AmountOfSweets amount) throws ImpossibleValueException {
        System.out.println("Началась драка между " + giving.getName() + " и " + taking.getName() + " за " + amount);
        if(isDraw(giving, taking)) {
            System.out.println("драка закончилась ничьей, все остаются при своих конфетах");
        }
        else {
            if(giving.getNumberOfSweets() >= amount.numberOfSweets()) {
                if(taking.hashCode() > giving.hashCode()) {
                    System.out.println(giving.getName() + " проиграл");
                    exchangeSweetsFromTo(giving, taking, amount);
                }
                else {
                    System.out.println(giving.getName() + " выиграл и остался при своих конфетах");
                }
            }
            else throw new ImpossibleValueException("У персонажа " + giving.getName() + " недостаточно конфет");
        }
    }

}