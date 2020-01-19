package Saper;

public class Menus {

    public static void menu1(){

        System.out.println("'A'- open a field");
        System.out.println("'S'- mark a bomb");
        System.out.println("'Q'- quit the game");
    }

    public static void menu2(boolean isItRow){
        if(isItRow)
        System.out.println("Row: ");
        else
            System.out.println("Column: ");
    }

    public static void title(){
        System.out.println("SUPER SAPER");
    }

    public static void exceptionOutOfBounds(){
        System.out.println("Wrong field, choose the correct one!");
    }

    public static void exceptionWrongFormat(){
        System.out.println("Wrong number format, try again!");
    }

    public static void wrongType() {
        System.out.println("Wrong type, try again!");
    }

    public static void exceptionAlreadyOpen() {
        System.out.println("This field is already open! Try another one!");
    }
}
