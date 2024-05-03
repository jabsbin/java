package kr.easw.lesson06;

public class ImplementationExample {

    public static void main(String[] args) {
        new Dog().speak();
        new Cat().speak();
        new Horse().speak();
    }

    interface Animal {
        void speak();
    }

    final static class Dog implements Animal {
        private void bark() {
            System.out.println("Bark!");
        }

        @Override
        public void speak() {
            bark();
        }
    }

    static class Cat implements Animal { // Cat 클래스가 Animal 인터페이스를 구현하도록 수정
        private void meow() {
            System.out.println("Meow!");
        }

        @Override
        public void speak() {
            meow();
        }
    }

    static class Horse implements Animal { // Horse 클래스가 Animal 인터페이스를 구현하도록 수정
        private void neigh() {
            System.out.println("Neigh!");
        }

        @Override
        public void speak() {
            neigh();
        }
    }
}
