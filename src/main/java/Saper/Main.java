package Saper;

public class Main {

    public static void main(String... arg){


        int matrixField = 10, numberOfBombs = 5;
        try {
            if(numberOfBombs > matrixField * matrixField) throw new CustomException();
            Game game = new Game(numberOfBombs, matrixField);

        } catch (CustomException e) {
            System.out.println("Too many bombs!!! World has exploded");
        }

    }
}
