package lesson5.backpack;

public class Packager {
    private Item[] items;
    private final int maxWeight;
    private Backpack bestPack;

    public Packager(Item[] items, int maxWeight) {
        this.items = items;
        this.maxWeight = maxWeight;
        this.bestPack = new Backpack(maxWeight);
    }

    public Backpack pack() {

        if (allFit()) return bestPack;

        pack(items.length);

        return bestPack;
    }

    private boolean allFit() {
        boolean allFit = true;
        Backpack backpack = new Backpack(maxWeight);

        for (Item item : items) {
            if (!backpack.add(item)) {
                allFit = false;
                break;
            }
        }
        if (allFit) {
            bestPack = backpack;
        }
        return allFit;
    }

    private void pack(int count) {

        if (count == 1) {
            return;
        }
        for (int i = 0; i < count; i++) {
            pack(count - 1);
            checkBestPack();
            rotate(count);
        }
    }

    private void checkBestPack() {

        Backpack backpack = new Backpack(maxWeight);

        for (Item item : items) {
            if (!backpack.add(item)) {
                break;
            }
        }
        if (backpack.compareTo(bestPack) > 0) {
            bestPack = backpack;
        }
    }

    private void rotate(int length) {
        int pos = items.length - length;
        Item temp = items[pos];
        for (int i = pos + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }

        items[items.length - 1] = temp;
    }
}
