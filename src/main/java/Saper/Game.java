package Saper;

import java.util.Scanner;

public class Game {
    private Matrix matrix;
    private int numberOfBombs;
    private int numberOfFields;
    private boolean gameOver;

    public Game(int numberOfBombs, int numberOfFields) throws MoreBombsThanFieldsException {
        this.numberOfBombs = numberOfBombs;
        this.numberOfFields = numberOfFields;
        this.gameOver = false;
        startGame();
        inGame();
    }

    private void startGame() throws MoreBombsThanFieldsException {
        Menus.title();
        Scanner key = new Scanner(System.in);
        Matrix.printStaticMatrix(this.numberOfFields);
        Menus.menu2(true);
        int x = key.nextInt();
        Menus.menu2(false);
        int y = key.nextInt();
        do {
            this.matrix = new Matrix(x, y, numberOfFields, numberOfBombs);
        }while(matrix.getMatrix()[x][y].numberOfBombsInSurround !=0 || matrix.getMatrix()[x][y].isBomb());
        matrix.openField(x,y);
        matrix.print();
    }

    private void inGame(){
        Scanner key = new Scanner(System.in);
        do {
            Menus.menu1();
            String choice = key.nextLine();
            if (choice.toUpperCase().equals("A")) {
                Menus.menu2(true);
                int x = key.nextInt();
                Menus.menu2(false);
                int y = key.nextInt();
                matrix.openField(x, y);
                if(matrix.getMatrix()[x][y].isBomb()) {
                    gameOver = true;
                    break;
                }
            } else if (choice.toUpperCase().equals("S")) {
                Menus.menu2(true);
                int x = key.nextInt();
                Menus.menu2(false);
                int y = key.nextInt();
                matrix.getMatrix()[x][y].setChecked(true);
            } else if (choice.toUpperCase().equals("Q")) {
                break;
            }
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
