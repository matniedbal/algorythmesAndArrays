package Cwiczenia11_01_2020;

public class CoffeeExpress {

    private int coffeeLevel;
    private int waterLevel;
    private int milkLevel;
    private CoffeeType coffeeType;

    public CoffeeExpress(int coffeeLevel, int waterLevel, int milkLevel, CoffeeType coffeeType) {
        this.coffeeLevel = coffeeLevel;
        this.waterLevel = waterLevel;
        this.milkLevel = milkLevel;
        this.coffeeType = coffeeType;
    }

    public int getCoffeeLevel() {
        return coffeeLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    @Override
    public String toString() {
        String coffeeType = "";
        if(this.getCoffeeType() == CoffeeType.Espresso) coffeeType = "Espresso";
        if(this.getCoffeeType() == CoffeeType.Americano) coffeeType = "Americano";
        if(this.getCoffeeType() == CoffeeType.Cappuchino) coffeeType = "Cappuchino";
        if(this.getCoffeeType() == CoffeeType.Latte) coffeeType = "Latte";

        return coffeeType+" - Smacznego";
    }
}


