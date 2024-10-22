package greedyTimes;

import java.util.Objects;

public class Item {

    private String name;
    private ItemType itemType;
    private long amount;

    public Item(String name, ItemType itemType, long amount) {
        this.name = name;
        this.itemType = itemType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name) && itemType == item.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemType, amount);
    }
}
