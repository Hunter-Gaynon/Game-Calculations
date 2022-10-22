package cases;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // cases work in a convoluted way within this game
    // I wrote this because I felt the odds of actually receiving certain items is deceiving and incorrect
    // this code can accurately simulate 300 million iterations of opening a case to get extremely accurate rates

    // Double is the key (represents a drop table such as 1/2, 1/10, etc)
    // ArrayList<Loot> is list of all drops within a drop table
    public static HashMap<Double, ArrayList<Loot>> dropTable = new HashMap<>();

    // initialize the dropTable HashMap as the class loads
    static {
        // iterate through all possible loot and put them into the proper tables within the dropTable HashMap
        for (Loot indexLoot : Loot.values()) {
            if (!dropTable.containsKey(indexLoot.getOdds())) {
                ArrayList<Loot> lootList = new ArrayList<>();
                lootList.add(indexLoot);
                dropTable.put(indexLoot.getOdds(), lootList);
            } else {
                dropTable.get(indexLoot.getOdds()).add(indexLoot);
            }
        }
    }

    public static void main(String[] args) {
        // real time in milliseconds
        double startTime = System.currentTimeMillis();
        // Loot is the key (represents a unique item from the case)
        // Integer is the total amount pulled
        HashMap<Loot, Integer> totalDrops = new HashMap<>();
        // set total obtained for each drop to 0
        for (Loot drop : Loot.values()) {
            totalDrops.put(drop, 0);
        }
        // total cases to open (300 million)
        int iterations = 300000000;
        for (int i = 1; i <= iterations; i++) {
            // print a message every 10% completed
            if (i % (iterations / 10.0) == 0) {
                System.out.println((i + " boxes opened"));
            }
            // drop = simulated reward from a case opening
            Loot drop = getLoot();
            // add 1 to the total drops which have been pulled
            totalDrops.put(drop, totalDrops.get(drop) + 1);
        }
        double caseWorth = 0.0;
        // print out statistics
        System.out.println("Time elapsed: " + ((System.currentTimeMillis() - startTime) / 1000) + "s");
        for (Loot item : totalDrops.keySet()) {
            int total = totalDrops.get(item);
            System.out.println(item.name() + "(1/" + (total > 0 ? iterations / total : "?") + ") -> " + 100.0 * total / iterations + "%");
            caseWorth += item.getValue() * ((double) total / iterations);
        }
        // find out true percents (1/2 is not 50%)
        // multiply drop rate by total items in a table
        for (Double rate : dropTable.keySet()) {
            Loot sample = null;
            int total = 0;
            for (Loot loot : Loot.values()) {
                if (loot.getOdds() == rate) {
                    sample = loot;
                    total++;
                }
            }
            if (sample != null) {
                System.out.println("Odds of getting a 1/" + (int) sample.getRate() + " drop are: 1/" +
                        ((int) ((100 / (((100.0 * totalDrops.get(sample)) / iterations) * total)) * 100)) / 100.0);
            }
        }
        System.out.println("This case provides loot equal to: " + caseWorth + " on average.");
    }

    // this method accurately simulates a single case opening within the game
    // each drop table attempts a success roll (repeat until at least one succeeds)
    // example drop tables: 1/2, 1/100, 1/400 (50%, 1%, 0.25%)
    // select one drop table that succeeded at random
    public static Loot getLoot() {
        // each drop table that succeeds in a roll will get 1 random item from the table added to the successfulTableRoll list
        ArrayList<Loot> successfulTableRolls = new ArrayList<>();
        // continue iterating until at least 1 successfulTableRoll has been found
        while (successfulTableRolls.size() == 0) {
            // iterate through each drop table
            for (Double rate : dropTable.keySet()) {
                // check if the random roll succeeds
                if (Math.random() <= rate) {
                    // roll succeeded, add a random drop from the successful table as a potentialDrop
                    ArrayList<Loot> indexDropTable = dropTable.get(rate);
                    Loot randomLoot = indexDropTable.get((int) (Math.random() * indexDropTable.size()));
                    successfulTableRolls.add(randomLoot);
                }
            }
        }
        // there are multiple drop tables that may succeed, pick 1 of the successful drops at random
        return successfulTableRolls.get((int) (Math.random() * (successfulTableRolls.size())));
    }


}
