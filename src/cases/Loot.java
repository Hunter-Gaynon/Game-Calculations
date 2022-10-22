package cases;

public enum Loot {

    // divine case
//    UPGRADE_TOKENS(2),
//    PVM_TICKETS(2),
//    GRAND_MYSTERY_BOX(2),
//    OP_CHEST(2),
//    LAUNCH_CHEST(2),
//    SILVER_CASKET(2),
//    RUBY_CASKET(10),
//    DIAMOND_CASKET(33),
//    FORTUNE_CHEST(33),
//    ONYX_CASKET(66),
//    ZENYTE_CASKET(100),
//    GOLD_CARD_PACK(100),
//    DIVINE_CHARGE(1500);

    // halloween box
//    UPGRADE_TOKEN(2),
//    PVM_TICKETS(2),
//    AUTUMN_BOX(3),
//    SPOOKY_BREW(20),
//    PUMPKIN_AMULET(500),
//    SCARECROW_MASK(500),
//    DEATHS_SCYTHE(1000),
//    WEREWOLF_TRANSFORMER(2000);

    // autumn box
    UPGRADE_TOKENS(2, 500000),
    PVM_TICKETS(2, 375000),
    GRAND_MYSTERY_BOX(2, 2400000),
    OP_CHEST(2, 1250000),
    LAUNCH_CHEST(2, 1400000),
    SILVER_CASKET(2, 5000000),
    RUBY_CASKET(10, 7500000),
    DIAMOND_CASKET(25, 13000000),
    FORTUNE_CHEST(25, 14000000),
    ONYX_CASKET(50, 28000000),
    ZENYTE_CASKET(100, 54000000),
    GOLD_CARD_PACK(100, 88000000),
    CORONET_OF_AUTUMN(1500, 8000000000.0),
    CLOAK_OF_AUTUMN(1500, 2500000000.0);


    private final double rate;
    private final double value;
    Loot(double rate, double value) {
        this.rate = rate;
        this.value = value;
    }
    public double getRate(){
        return this.rate;
    }
    public double getOdds() {
        return 1 / rate;
    }

    public double getValue() {
        return value;
    }
}