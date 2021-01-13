package com.company;

public class Malish extends Character implements DependentOnPosition{

    private int position;
    public Malish(String name, String gender, int power, int weight, AmountOfSweets amount, int position, int moodLevel) throws WrongInputException{
        super(name, gender, power, weight, amount, moodLevel);
        this.position = position;
    }

    static class Puppy implements DependentOnPosition {
        private String name;
        private int weight;
        private int sweetsInStomach;
        private int position;

        public Puppy(String name, int weight, int sweetsInStomach, int position) {
            this.name = name;
            this.weight = weight;
            this.sweetsInStomach = sweetsInStomach;
            this.position = position;
        }

        public int getWeight() {
            return this.weight;
        }

        public String getName(){
            return name;
        }

        public void buckUp() {
            System.out.println(name + " встряхнулся");
        }

        public void lick(Malish malish) {
            System.out.println(name + " лизнул " + malish.getName());
            malish.increaseMoodLevel(2);
        }

        public boolean canFallAsleep(int sweetsInStomach) {
            return sweetsInStomach >= 1;
        }

        public void fallAsleep() {
            if(canFallAsleep(sweetsInStomach)) { System.out.println(name + " уснул и " + sniffle()); }
            else { System.out.println(name + " не смог уснуть на голодный желудок"); }
        }

        public String sniffle() {
            return name + " начал сопеть";
        }

        @Override
        public int getPosition() {
            return position;
        }

        @Override
        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return getName() + " c " + Integer.toString(sweetsInStomach) + " конфетами в желудке весом " + Integer.toString(weight);
        }
    }



    public boolean canFeed(int numberOfSweets) { return numberOfSweets >= 1; }

    public void feed(Puppy puppy, AmountOfSweets amount) {
        removeSweets(amount.weight());
        puppy.sweetsInStomach += amount.numberOfSweets();
        puppy.weight += amount.weight();
        System.out.println(getName() + " накормил " + puppy.name + " " + amount);
    }

    public void areHappy(Object[] stageParticipant) {
        int counter = 0;
        for(Object character : stageParticipant) {
            if(character == null) counter += 1;
        }
        if(counter == stageParticipant.length) System.out.println(getName() + " обрадовался, что остался один");
        else System.out.println(getName() + " расстроился, что не все ушли");
    }



    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

}
