package lesson5;

import lesson5.backpack.Backpack;
import lesson5.backpack.Item;
import lesson5.backpack.Packager;

import java.util.ArrayList;
import java.util.List;

import static lesson5.Degree.degree;

public class Main {

    public static void main(String[] args) {

        task1(0,-1);
        task1(2,3);
        task1(2,-3);
        task1(3,3);

        task2();
    }

    private static void task1(float x, int degree) {
        System.out.printf("%.1f ^%2d = %.3f%n", x, degree, degree(x, degree));
    }

    private static void task2() {

        List<Item> items = new ArrayList<>();

        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40_000));
        items.add(new Item("Котелок", 1, 500));

        Item[] itemArr = new Item[items.size()];
        itemArr = items.toArray(itemArr);

        Backpack bestPack = new Packager(itemArr, 5).pack();
        bestPack.display();
    }
}
