package kr.easw.lesson3;

import java.util.Random;

public class RollTheDice {
    private static int[] frequency = new int[6];
    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        simulateDiceRolls();
        printDiceFrequency();
    }

    private static void simulateDiceRolls() {
        for (int i = 0; i < 600; i++) {
            double result = RANDOM.nextDouble() * 6 + 1; // 주사위 눈의 값은 1부터 6까지이므로 6을 곱한 후 1을 더합니다.
            fillArray(result);
        }
    }

    private static void fillArray(double result) {
        int index = (int) result - 1; // 주사위 눈의 값은 1부터 시작하므로 1을 빼줍니다.
        frequency[index]++;
    }

    private static void printDiceFrequency() {
        for (int i = 0; i < frequency.length; i++) {
            System.out.printf("주사위 눈 %d의 빈도: %d\n", i + 1, frequency[i]);
        }
    }
}
