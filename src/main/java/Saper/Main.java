package Saper;

public class Main {

    public static void main(String... arg){

        Matrix matrix = null;
        int matrixField = 10, numberOfBombs = 10;
        try {
            if(numberOfBombs > matrixField * matrixField) throw new MoreBombsThanFieldsException();
            matrix = new Matrix(3,5,matrixField,numberOfBombs);
            matrix.print();

            int counter = 0;
            for (int i = 0; i < matrix.getMatrix().length; i++) {
                for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
                    matrix.getMatrix()[i][j].setOpen(true);
                }
            }
            matrix.print();


        } catch (MoreBombsThanFieldsException e) {
            System.out.println("Too many bombs!!! World has exploded");
        }




    }

}
