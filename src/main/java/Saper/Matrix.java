package Saper;

public class Matrix {

    private Field[][] matrix;
    private int numberOfBombs;
    private int numberOfFields;
    private boolean[] bombFields;
    private Field startingField;
    private int xFirst;
    private int yFirst;

    public Matrix(int xFirst, int yFirst, int n, int numberOfBombs) throws MoreBombsThanFieldsException {
        this.xFirst = xFirst;
        this.yFirst = yFirst;
        this.numberOfBombs = numberOfBombs;
        this.matrix = new Field[n][n];
        this.numberOfFields = n * n;
        bombFieldsArr();
        generateMatrix();
        setNeighours();
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

    public Field findByID(int iD){
        int counter = 0;
        if(iD <= numberOfFields) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    counter++;
                    if(counter == iD) return matrix[i][j];
                }
            }
        }
        return null;
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



    private void generateMatrix(){

        int counter = 0;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i==0) {
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,null,null,null,null,matrix[i][j+1],null,matrix[i+1][j],matrix[i+1][j+1]);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,null,null,null,matrix[i][j-1],null,matrix[i+1][j-1],matrix[i+1][j],null);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,null,null,null,matrix[i][j-1],matrix[i][j+1],matrix[i+1][j-1],matrix[i+1][j],matrix[i+1][j+1]);
                    }
                }else if(i>0 && i<matrix.length-1) {
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,null,matrix[i-1][j],matrix[i-1][j+1],null,matrix[i][j+1],null,matrix[i+1][j],matrix[i+1][j+1]);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,matrix[i-1][j-1],matrix[i-1][j],null,matrix[i][j-1],null,matrix[i+1][j-1],matrix[i+1][j],null);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1],matrix[i][j-1],matrix[i][j+1],matrix[i+1][j-1],matrix[i+1][j],matrix[i+1][j+1]);
                    }
                }else if(i == matrix.length-1){
                    if(j == 0){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,null,matrix[i-1][j],matrix[i-1][j+1],null,matrix[i][j+1],null,null,null);
                    }else if(j == matrix[i].length-1){
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,matrix[i-1][j-1],matrix[i-1][j],null,matrix[i][j-1],null,null,null,null);
                    }else{
                        matrix[i][j] = new Field(this.bombFields[counter],false,false,matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1],matrix[i][j-1],matrix[i][j+1],null,null,null);
                    }
                }
                counter ++;
                matrix[i][j].setiD(counter);

            }
        }
    }

    public void setFieldToOpen(int x, int y){
        matrix[y][x].setOpen(true);
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

}
