package lesson2;

import lesson2.arrays.Array;
import lesson2.arrays.ArrayImpl;

public class Main {
    private static final int ARRAY_LENGTH = 1_000;//_000;
    private static Array<Integer> arr1 = new ArrayImpl<>(ARRAY_LENGTH);
    private static Array<Integer> arr2 = new ArrayImpl<>(ARRAY_LENGTH);
    private static Array<Integer> arr3 = new ArrayImpl<>(ARRAY_LENGTH);

    public static void main(String[] args) {
        Integer value = 128;
        arr1.add(value);
        System.out.printf("В массиве %sнайдено значение %d%n", (arr1.indexOf(value) == -1 ? "не " : ""), value);
        arr1.remove(value);

        fillRandomInt();

        long timerStartTime;

        System.out.printf("%-30s", "Пузырьковая сортировка");
        timerStartTime = currentTime();
        arr1.sortBubble();
        printTimerResult(timerStartTime);

        System.out.printf("%-30s", "Сортировка методом выбора");
        timerStartTime = currentTime();
        arr2.sortSelect();
        printTimerResult(timerStartTime);

        System.out.printf("%-30s", "Сортировка методом вставки");
        timerStartTime = currentTime();
        arr3.sortInsert();
        printTimerResult(timerStartTime);
    }

    private static void printTimerResult(long timerStartTime) {

        System.out.printf("%d ms%n", currentTime() - timerStartTime);
    }

    private static long currentTime() {
        return System.currentTimeMillis();
    }

    private static void fillRandomInt() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            Integer value = (int) (Math.random() * ARRAY_LENGTH);
            arr1.add(value);
            arr2.add(value);
            arr3.add(value);
        }
    }
}
