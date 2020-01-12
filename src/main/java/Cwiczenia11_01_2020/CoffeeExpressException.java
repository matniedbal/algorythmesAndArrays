package Cwiczenia11_01_2020;

public class CoffeeExpressException extends Exception {
}

class NoCoffeeException extends CoffeeExpressException {}

class NoWaterException extends CoffeeExpressException {}

class NoMilkException extends CoffeeExpressException {}
