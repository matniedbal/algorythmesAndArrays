package Saper;

public class Matrix {

    private Field[][] matrix;
    private int numberOfBombs;
    private int numberOfFields;
    private boolean[] bombFields;
    private int xFirst;
    private int yFirst;

    public Matrix(int xFirst, int yFirst, int n, int numberOfBombs) throws CustomException {
        this.xFirst = xFirst;
        this.yFirst = yFirst;
        this.numberOfBombs = numberOfBombs;
        this.numberOfFields = n * n;
            this.matrix = new Field[n][n];
            bombFieldsArr();
            generateMatrix();
            setNeighours();
    }

    public int getNumberOfClosedFields(){
        int temp = 0;
        for(int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(!matrix[i][j].isOpen) temp ++;
            }
        }
        return temp;
    }

    private boolean[] bombFieldsArr() {
        this.bombFields = new boolean[numberOfFields];
        for(boolean el: this.bombFields) el = false;
        int temp;
        for (int i = 0; i < numberOfBombs; i++) {
            temp = (int) (Math.random() * numberOfFields-1);

            if (!this.bombFields[temp] || temp != getFieldId(xFirst,yFirst)) {
                this.bombFields[temp] = true;
            } else if(this.bombFields[temp] || temp == getFieldId(xFirst,yFirst)){
                i -= 1;
            }
        }
        return this.bombFields;
    }

    public int getFieldId (int x , int y){
        int iDCounter = 0;
        for(int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                iDCounter ++;
            }
        }
        return iDCounter;
    }



    public Field[][] getMatrix() {
        return matrix;
    }

    private void setNeighours(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int numberOfBombsInSurround = 0;
                try {
                    if (matrix[i-1][j - 1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i-1][j].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i-1][j+1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i][j-1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i][j+1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i+1][j-1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i+1][j].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (matrix[i+1][j+1].isBomb()) numberOfBombsInSurround++;
                }catch(ArrayIndexOutOfBoundsException ignored){
                }
                matrix[i][j].setNumberOfBombsInSurround(numberOfBombsInSurround);
            }
        }
    }

    public void openField(int x, int y){
        if(x>=0 && x < matrix.length && y>=0 && y < matrix[x].length && !matrix[x][y].isBomb() && !matrix[x][y].isOpen){
            matrix[x][y].setOpen(true);
                if (x > 0 && matrix[x][y].numberOfBombsInSurround == 0 ) openField(x-1,y);
                if (y > 0 && matrix[x][y].numberOfBombsInSurround == 0 ) openField(x,y-1);
                if (x < matrix.length-1 && matrix[x][y].numberOfBombsInSurround == 0 ) openField(x+1,y);
                if (y < matrix[x].length-1 && matrix[x][y].numberOfBombsInSurround == 0 ) openField(x, y+1);
        }
    }

    public void openAll(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j].isOpen=true;
            }
        }
    }

    private void generateMatrix(){
        int counter = 0;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i==0) {
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }
                }else if(i>0 && i<matrix.length-1) {
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }
                }else if(i == matrix.length-1){
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false);
                    }
                }
                counter ++;
            }
        }
    }

    public void print(){
        System.out.print("   ");
        for(int j = 0; j < matrix.length; j++){
            for(int f = 1; f <= 3-String.valueOf(j).length(); f++) System.out.print(" ");
            System.out.print(j);
        }
        System.out.println("");
        for(int j = 0; j < matrix.length*4; j++){
            System.out.print("-");}
        System.out.println();
        for(int i = 0 ; i < matrix.length; i++){
            System.out.print(i);
            for(int f = 1; f <= 3-String.valueOf(i).length()-1; f++) System.out.print(" ");
            System.out.print(" |");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(" "+matrix[i][j].toString()+" ");
            }
            System.out.println("");
        }
    }

    public static void printStaticMatrix(int numberOfFields){
        System.out.print("   ");
        for(int j = 0; j < numberOfFields; j++){
            for(int f = 1; f <= 3-String.valueOf(j).length(); f++) System.out.print(" ");
            System.out.print(j);
        }
        System.out.println("");
        for(int j = 0; j < numberOfFields*4; j++){
            System.out.print("-");}
        System.out.println();
        for(int i = 0 ; i < numberOfFields; i++){
            System.out.print(i);
            for(int f = 1; f <= 3-String.valueOf(i).length()-1; f++) System.out.print(" ");
            System.out.print(" |");
            for(int j = 0; j < numberOfFields; j++){
                System.out.print(" \u25A1 ");
            }
            System.out.println("");
        }
    }
}
