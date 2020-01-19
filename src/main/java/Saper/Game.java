package Saper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Matrix matrix;
    private int numberOfBombs;
    private int numberOfFields;
    private boolean gameOver;

    public Game(int numberOfBombs, int numberOfFields) throws CustomException {
        this.numberOfBombs = numberOfBombs;
        this.numberOfFields = numberOfFields;
        this.gameOver = false;
        startGame();
        inGame();
    }

    private void startGame() throws CustomException {
        Menus.title();
        Scanner key = new Scanner(System.in);
        Matrix.printStaticMatrix(this.numberOfFields);
        try {
            int x,y;
            Menus.menu2(true);
            x = key.nextInt();
            Menus.menu2(false);
            y = key.nextInt();
        do {
            this.matrix = new Matrix(x, y, numberOfFields, numberOfBombs);
        }while(matrix.getMatrix()[x][y].numberOfBombsInSurround !=0 || matrix.getMatrix()[x][y].isBomb());
        matrix.openField(x,y);
        }catch(InputMismatchException ex){
            Menus.exceptionWrongFormat();
            startGame();
        }catch(ArrayIndexOutOfBoundsException ex2){
            Menus.exceptionOutOfBounds();
            startGame();
        }
        matrix.print();
    }

    private void inGame(){
        Scanner key = new Scanner(System.in);
        do {
            Menus.menu1();
            String choice = key.nextLine();
            if (choice.toUpperCase().equals("A")) {
                try {
                    int x, y;
                    Menus.menu2(true);
                    x = key.nextInt();
                    Menus.menu2(false);
                    y = key.nextInt();
                    matrix.openField(x, y);
                    if(matrix.getMatrix()[x][y].isBomb()) {
                        gameOver = true;
                        break;
                    }
                }catch(InputMismatchException ex){
                    Menus.exceptionWrongFormat();
                    continue;
                }catch(ArrayIndexOutOfBoundsException ex2){
                    Menus.exceptionOutOfBounds();
                    continue;
                }

            } else if (choice.toUpperCase().equals("S")) {
                Menus.menu2(true);
                try {
                    int x, y;
                     x = key.nextInt();
                    Menus.menu2(false);
                     y = key.nextInt();
                    matrix.getMatrix()[x][y].setChecked(true);
                }catch(InputMismatchException ex){
                    Menus.exceptionWrongFormat();
                    continue;
                }catch(ArrayIndexOutOfBoundsException ex2){
                    Menus.exceptionOutOfBounds();
                    continue;
                }
            } else if (choice.toUpperCase().equals("Q")) {
                break;
            } else Menus.wrongType();
            matrix.print();
        }while(matrix.getNumberOfClosedFields() > this.numberOfBombs);
        if(gameOver) {
            matrix.openAll();
            System.out.println();
            matrix.print();
            System.out.println("GAME OVER");
        }else {
            matrix.openAll();
            System.out.println();
            matrix.print();
            System.out.println("CONGRATULATIONS !!!");
        }
    }
}
