package Saper;

public class Menus {

    public static void menu1(){

        System.out.println("'A'-odkryj pole");
        System.out.println("'S'-oznacz bombe");
        System.out.println("'Q'-wyjdź z gry");
    }

    public static void menu2(boolean isItRow){
        if(isItRow)
        System.out.println("podaj rząd: ");
        else
            System.out.println("podaj kolumnę: ");
    }

    public static void title(){
        System.out.println("SUPER SAPER");
    }

}
