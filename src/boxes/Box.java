package boxes;

public class Box {
    // lists of loot in each drop table
    private final Items[] commonLoot;
    private final Items[] uncommonLoot;
    private final Items[] rareLoot;

    // calculate average price as the object is created
    // since the items in the list never change, these are only needed to be calculated once
    private final double commonLootAverageValue;
    private final double uncommonLootAverageValue;
    private final double rareLootAverageValue;

    // boxes are immutable objects
    public Box(Items[] commonLoot, Items[] uncommonLoot, Items[] rareLoot) {
        this.commonLoot = commonLoot;
        this.uncommonLoot = uncommonLoot;
        this.rareLoot = rareLoot;
        this.commonLootAverageValue = calculateAverageValue(commonLoot);
        this.uncommonLootAverageValue = calculateAverageValue(uncommonLoot);
        this.rareLootAverageValue = calculateAverageValue(rareLoot);
    }

    // return the average wealth from a singular drop table
    public double getAverageValue(DropTable dropTable) {
        if (dropTable.equals(DropTable.COMMON)) {
            return commonLootAverageValue;
        } else if (dropTable.equals(DropTable.UNCOMMONN)) {
            return uncommonLootAverageValue;
        } else if (dropTable.equals(DropTable.RARE)) {
            return rareLootAverageValue;
        }
        return -1.0;
    }

    // each box opened will yield 1 random item from a drop table
    // 60% chance to get a common, 35% uncommon, 5% rare
    public double getAverageLoot() {
        return commonLootAverageValue * 0.6 +
                uncommonLootAverageValue * 0.35 +
                rareLootAverageValue * 0.05;
    }

    // return the average of a list of items
    private double calculateAverageValue(Items[] items) {
        double total = 0;
        for (Items item : items) {
            total += item.getBestValue();
        }
        return total / items.length;
    }

    public Items[] getCommonLoot() {
        return commonLoot.clone();
    }

    public Items[] getUncommonLoot() {
        return uncommonLoot.clone();
    }

    public Items[] getRareLoot() {
        return rareLoot.clone();
    }
}
