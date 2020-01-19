package ZlozonoscObliczeniowa;

public class Matrix {

    private int[][] array;

    public Matrix (int n){
        this.array = new int[n][n];
        this.generateMatrix();
    }

    public int sum (){
        int sumOfMatrixElements = 0;
        for(int i = 0 ; i < this.array.length; i++){
            for(int j = 0; j < this.array[i].length; j++){
                sumOfMatrixElements += this.array[i][j];
            }
        }
        return sumOfMatrixElements;
    }

    private void generateMatrix (){
        int a = 0;
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                a += 1;
                array[i][j] = a*a;
            }
        }
    }

    public void print(){
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print("["+array[i][j]+"]");
            }
            System.out.println();
        }
    }

    public int[][] getArray() {
        return array;
    }
}
