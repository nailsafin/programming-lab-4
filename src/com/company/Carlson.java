package com.company;

public class Carlson extends Character implements DependentOnPosition, ExchangingSweets, Retiring {

    /**Целочисленное значение позиции персонажа*/
    private int position;
    Propeller prop;

    /**Конструктор персонажа Карлсон*/
    public Carlson(String name, String gender, int power, int weight, AmountOfSweets amount, int position, int moodLevel) throws WrongInputException {
        super(name, gender, power, weight, amount, moodLevel);
        this.position = position;
        this.prop = new Propeller(10, 180, 20);
        addWeight(prop.weight);
    }

    class Propeller {
        private final int weight;
        private final int liftingForce;
        private final int fuelRate;

        private Propeller(int weight, int liftingForce, int fuelRate) {
            this.weight = weight;
            this.liftingForce = liftingForce;
            this.fuelRate = fuelRate;
        }

        private boolean canStart(int numberOfSweets) {
            return fuelRate <= numberOfSweets;
        }

        private boolean canLift(int weight, int numberOfSweets) {
            return weight <= liftingForce && canStart(numberOfSweets);
        }

        private void start() {
            if(canStart(getNumberOfSweets())) System.out.println("Пропеллер завелся");
            else System.out.println(prop + " не завелся");
        }

        @Override
        public String toString() {
            return "пропеллер Карлсона";
        }
    }



    /**Определяет возможность пересчета конфет*/
    public boolean isHereWhatToCount(int numberOfSweets) {
        return numberOfSweets > 1;
    }

    public void count(int numberOfSweets) {
        if(isHereWhatToCount(numberOfSweets)) {

            System.out.println(getName() + " пересчитал конфеты - " + getNumberOfSweets() + " штук!");
        }
    }



    /**Определяет возмонжость взлететь*/
    public boolean canFlyAway(int weight, int numberOfSweets) {
        return prop.canLift(weight, numberOfSweets);
    }

    public void flyAway(int weight, int numberOfSweets) {
        prop.start();
        if(canFlyAway(weight, numberOfSweets)) System.out.println(getName() + " вылетел в окно" + leavingMood());
        else {
            System.out.println(getName() + " попытался взлететь, но не смог");
        }
    }



    /**Определяет возможность прделиться конфетами*/
    public boolean canShare(int numberOfSweets, int moodLevel) {
        return getMoodLevel() > 2 && getNumberOfSweets() > 70;
    }

    /**Реализует процесс раздачи конфет персонажем*/
    public void share(Kirre kirre, Gunilla gunilla, Carlson carlson, AmountOfSweets amount) throws ImpossibleValueException{
        if(getNumberOfSweets() >= amount.numberOfSweets()) {
            if(canShare(getNumberOfSweets(), getMoodLevel())) {
                System.out.println(getName() + " поделился с остальными и дал каждому по конфете");
                exchangeSweetsFromTo(carlson, kirre, amount);
                exchangeSweetsFromTo(carlson, gunilla, amount);
                count(getNumberOfSweets());
            }
            else {
                System.out.println(getName() + " не поделился и стал считать конфеты");
                count(getNumberOfSweets());
            }
        }
        else throw new ImpossibleValueException("У Карлсона недостаточно конфет, чтобы поделиться");
    }

    /**Определяет возможность обиды персонажа*/
    public boolean shouldTakeOffence(String conclusion) {
        return conclusion.equals("Гунилла сделала вывод: " + getName() + " мудак");
    }

    /**Возвращает реакцию персонажа на заключение в виде строки*/
    public String takeOffence(String conclusion) {
        if(shouldTakeOffence(conclusion)) {
            return getName() + " обиделся";
        }
        else {
            return getName() + " польщен";
        }
    }

    public int moveToPosition(int position, Malish.Puppy puppy) {
        this.position = position;
        puppy.setPosition(position);
        return this.position;
    }



    @Override
    public void gone() {
        flyAway(getWeight(), getNumberOfSweets());
    }

    @Override
    public String leavingMood() {
        if(getNumberOfSweets() > 30) return " с улыбкой на лице";
        else return " махнув пропеллером вслед";
    }

    @Override
    public int getPosition() {
        if(canFlyAway(getWeight(), getNumberOfSweets())) {
            position -= 1;
        }
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }
}