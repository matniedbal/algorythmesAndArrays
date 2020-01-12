package Cwiczenia11_01_2020;


public class Main {


    public static void main (String... args) throws Exception{

        try {
            CoffeeExpress coffeeExpress = new CoffeeExpress(20,10,100, CoffeeType.Americano);
            if((coffeeExpress.getWaterLevel() < 10 && (coffeeExpress.getCoffeeType() == CoffeeType.Espresso || coffeeExpress.getCoffeeType() == CoffeeType.Latte )) ||
                    (coffeeExpress.getWaterLevel() < 30 && coffeeExpress.getCoffeeType() == CoffeeType.Cappuchino) ||
                    (coffeeExpress.getWaterLevel() < 50 && coffeeExpress.getCoffeeType() == CoffeeType.Americano) ||
                    coffeeExpress.getCoffeeType() == CoffeeType.HotWater && coffeeExpress.getWaterLevel() <=0 ) throw new NoWaterException();
            if(coffeeExpress.getCoffeeLevel() < 10) throw new NoCoffeeException();
            if((coffeeExpress.getMilkLevel() < 30 && coffeeExpress.getCoffeeType() == CoffeeType.Cappuchino) ||
                    (coffeeExpress.getMilkLevel() < 60 && coffeeExpress.getCoffeeType() == CoffeeType.Latte)) throw new NoMilkException();
            System.out.println(coffeeExpress.getCoffeeType()+" - Smacznego!");
        } catch (NoWaterException e) {
            System.out.println("No water");
        }catch (NoCoffeeException e) {
            System.out.println("No coffee");
        }catch (NoMilkException e) {
            System.out.println("No milk");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
