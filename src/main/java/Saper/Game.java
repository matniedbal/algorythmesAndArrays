package Saper;

import java.util.Scanner;

public class Game {
    private Matrix matrix;
    private int numberOfBombs;
    private int numberOfFields;
    private Field startingField;

    public Game(int numberOfBombs, int numberOfFields) throws MoreBombsThanFieldsException {
        this.numberOfBombs = numberOfBombs;
        this.numberOfFields = numberOfFields;
        startGame();
    }

    private void startGame() throws MoreBombsThanFieldsException {
        Scanner key = new Scanner(System.in);
        System.out.print("Podaj wiersz: ");
        int y = key.nextInt();
        System.out.print("Podaj wiersz: ");
        int x = key.nextInt();
        this.matrix = new Matrix(x,y,numberOfFields,numberOfBombs);

    }



    private Field getFirstField(int i, int j){
        return null;
    }



}
