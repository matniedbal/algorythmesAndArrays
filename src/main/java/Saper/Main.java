package Saper;

public class Main {

    public static void main(String... arg){
        int matrixField = 23, numberOfBombs = 90;
        try {
                if(numberOfBombs > matrixField * matrixField) throw new CustomException();
                Game game = new Game(numberOfBombs, matrixField);
        } catch (CustomException e) {
            System.out.println("Too many bombs!!! The world has exploded");
        }
    }
}
