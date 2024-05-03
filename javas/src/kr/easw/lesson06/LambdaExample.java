package kr.easw.lesson06;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExample {
    private static final Random RANDOM = new Random();
    private static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Supplier<Integer> numberSupplier = () -> numbers[RANDOM.nextInt(numbers.length)];
    private static final Function<Integer, Integer> negativeConverter = (number) -> -number;
    private static final Consumer<Integer> printer = (number) -> {
        System.out.println(number);
    };
    private static final BiFunction<Integer, Integer, Integer> adjuster = (number, adjustment) -> number + adjustment;

    public static void main(String[] args) {
        int first = numberSupplier.get();
        int second = numberSupplier.get();
        int example = exampleResult(first, second);
        int lambda = lambdaResult(first, second);
        if (example == lambda) {
            System.out.println("정답입니다!");
        } else {
            System.out.println("오답입니다!");
        }
    }

    private static int exampleResult(int base, int delta) {
        int negative = -delta;
        int adjusted = base + delta;
        System.out.println(negative);
        return adjusted;
    }

    private static int lambdaResult(int base, int delta) {
        // base와 delta 값을 처리하여 결과를 반환하는 람다 표현식을 작성합니다.
        // exampleResult 메서드와 동일한 동작을 수행해야 합니다.

        // 음수로 변환하는 람다 표현식
        Function<Integer, Integer> negativeConverter = (number) -> -number;
        int negative = negativeConverter.apply(delta);
        System.out.println(negative);

        // 두 값을 더하는 람다 표현식
        BiFunction<Integer, Integer, Integer> adjuster = (num1, num2) -> num1 + num2;
        int adjusted = adjuster.apply(base, delta);

        // 조정된 값을 반환합니다.
        return adjusted;
    }
}
