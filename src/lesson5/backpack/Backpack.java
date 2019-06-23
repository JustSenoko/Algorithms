package lesson5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack implements Comparable<Backpack>{

    private final int maxWeight;
    private List<Item> items = new ArrayList<>();
    private int weight;
    private int price;

    Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    boolean add(Item item) {
        if (notFits(item)) {
            return false;
        }
        items.add(item);
        weight += item.getWeight();
        price += item.getPrice();
        return true;
    }

    public boolean remove(Item item) {
        if (items.remove(item)) {
            weight =- item.getWeight();
            price =- item.getPrice();
            return true;
        }
        return false;
    }

    private boolean notFits(Item item) {
        return (weight + item.getWeight() > maxWeight);
    }

    private int getPrice() {
        return price;
    }

    public void display() {
        System.out.printf("Содержимое рюкзака (вес %d, цена %d):%n", weight, price);
        for (Item item:items) {
            System.out.printf(" - %s (вес %d, цена %d);%n", item.getName(), item.getWeight(), item.getPrice());
        }
    }

    @Override
    public int compareTo(Backpack o) {
        return Integer.compare(this.price, o.getPrice());
    }
}
