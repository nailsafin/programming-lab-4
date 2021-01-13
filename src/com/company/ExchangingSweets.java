package com.company;

public interface ExchangingSweets {
    /**Реализует процесс передачи некоторого количества конфет между персонажами*/
    default void exchangeSweetsFromTo(Character giving, Character taking, AmountOfSweets amount) throws ImpossibleValueException {
        if(giving.getNumberOfSweets() >= amount.numberOfSweets()) {
            giving.removeSweets(amount.numberOfSweets());
            giving.decreaseMoodLevel(1);

            taking.addSweets(amount.numberOfSweets());
            taking.increaseMoodLevel(1);

            System.out.println(giving.getName() + " отдал " + taking.getName() + " " + amount);
        }
        else throw new ImpossibleValueException("у персонажа " + giving.getName() +
                " недостаточно конфет, чтобы отдать их персонажу " + taking.getName());
    }
}