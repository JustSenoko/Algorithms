package lesson5.backpack;

public class Item {

    private int weight;
    private int price;
    private String name;

    public Item(String name, int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    int getWeight() {
        return weight;
    }

    int getPrice() {
        return price;
    }

    String getName() {
        return name;
    }
}
