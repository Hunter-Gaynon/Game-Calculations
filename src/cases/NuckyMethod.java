package cases;

import java.util.ArrayList;
import java.util.HashMap;

public class NuckyMethod {
    // method written by Nucky
    public static Loot getLoot1(Loot[] loot) {
        HashMap<Double, ArrayList<Loot>> dropTable = new HashMap<>();
        ArrayList<Loot> potentialDrops = new ArrayList<>();
        // Loops through all the items individually and groups them into drop tables
        // In the example you showed the drop tables would be: 1/2, 1/10, 1/33, 1/66, 1/100, 1/1500
        // So 6 items in the 1/2 table, 1 in the 1/10 etc
        for (Loot item : loot) {
            if (item == null) {
                continue;
            }
            double oddsIndex = item.getOdds();
            if (!dropTable.containsKey(oddsIndex)) {
                ArrayList<Loot> items = new ArrayList<>();
                items.add(item);
                dropTable.put(oddsIndex, items);
            } else {
                dropTable.get(oddsIndex).add(item);
            }
        }
        // Loops through all the drop tables and generates a random decimal number(0-100) to see if it is lower than the drop rate for each table
        // If the random number generated is less than the drop rate for that specific table then a random item from the drop table gets added to an array named potentialDrops
        // Example: Random number generated 48.34 is lower than 50% drop rate (1/2 drop table) so a random item from the drop table will get added to the array
        for (double rate : dropTable.keySet()) {
            double randomNumber = Math.random();
            if (randomNumber <= rate) {
                ArrayList<Loot> dropTableLoot = dropTable.get(rate);
                Loot randomLoot = dropTableLoot.get(Misc.getRandom(dropTable.get(rate).size() - 1));
                potentialDrops.add(randomLoot);
            }
        }
        // If there is at least one item in the possibleDrops array then it selects a random item from there as the drop
        if (potentialDrops.size() > 0) {
            return potentialDrops.get(Misc.getRandom(potentialDrops.size() - 1));
        }
        // In the case that there is nothing in the possibleDrops array, then the whole process gets repeated until a drop is received(Recursion)
        else {
            return getLoot1(loot);
        }
    }
}
