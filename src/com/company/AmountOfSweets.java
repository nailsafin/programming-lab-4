package com.company;

public enum AmountOfSweets {
    BAG(10,10, "кулёк конфет"),
    BOX(50, 50, "коробка для входных конфет"),
    ONEPIECE(1, 1, "одна конфета");

    private final int numberOfSweets;
    private final int weight;
    private final String name;

    /**Конструктор емкости*/
    AmountOfSweets(int numberOfSweets, int weight, String name) {
        this.numberOfSweets = numberOfSweets;
        this.weight = weight;
        this.name = name;
    }

    /**Возвращает количество конфет, содержащихся в емкости*/
    public int numberOfSweets() {
        return this.numberOfSweets;
    }

    /**Возвращает массу емкости*/
    public int weight() {
        return this.weight;
    }

    /**Возвращает описание (название) емкости*/
    public String toString() {
        return this.name;
    }
}