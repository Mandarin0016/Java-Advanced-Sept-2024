package greedyTimes;

public enum ItemType {
    Gold,
    Gem,
    Cash;

    public static ItemType getItem(String name) {

        ItemType itemType = null;

        if (name.length() == 3) {
            itemType = ItemType.Cash;
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = ItemType.Gem;
        } else if (name.equalsIgnoreCase("gold")) {
            itemType = ItemType.Gold;
        }

        return itemType;
    }
}
