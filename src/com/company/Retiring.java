package com.company;

public interface Retiring extends ExchangingSweets{
    void gone();
    String leavingMood();
    default String leaveGift(AmountOfSweets amount, Malish malish, Character character) throws ImpossibleValueException {

        class Gift {
            AmountOfSweets amount;
            Malish malish;

            Gift(AmountOfSweets amount, Malish malish) {
                this.amount = amount;
                this.malish = malish;
            }

            private AmountOfSweets getAmount() {
                return amount;
            }

            private String getCelebrantName() {
                return malish.getName();
            }

            @Override
            public String toString() {
                return amount + " - подарок от " + character.getName() + " ";
            }
        }

        Gift gift = new Gift(amount, malish);

        if(character.getNumberOfSweets() >= gift.getAmount().numberOfSweets())
            ExchangingSweets.super.exchangeSweetsFromTo(character, malish, amount);
        else
            throw new ImpossibleValueException("Кажется, у персонажа " + character.getName() + " недостаточно конфет для подарка");

        return gift + malish.getName();
    }
}
