package kr.easw.lesson06;

public class AbstractionExample {

    public static void main(String[] args) {
        new Car("Car").run();
        new Bicycle("Bicycle").run();
        new Motorcycle("Motorcycle").run();
    }

    abstract static class Vehicle {
        private final String name;

        public Vehicle(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void run();
    }

    static class Car extends Vehicle {
        public Car(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + " is running!");
        }
    }

    static class Bicycle extends Vehicle { // Bicycle 클래스가 Vehicle 추상 클래스를 상속하도록 수정
        public Bicycle(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + " is running!");
        }
    }

    static class Motorcycle extends Vehicle { // Motorcycle 클래스가 Vehicle 추상 클래스를 상속하도록 수정
        public Motorcycle(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + " is running!");
        }
    }
}
