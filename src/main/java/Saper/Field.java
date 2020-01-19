package Saper;

public class Field {

    private boolean isBomb;
    boolean isChecked;
    boolean isOpen;
    int numberOfBombsInSurround;
    private Field upperLeftField;
    private Field upperField;
    private Field upperRightField;
    private Field leftField;
    private Field rightField;
    private Field bottomLeftField;
    private Field bottomField;
    private Field bottomRightField;
    private int iD;


    public Field(boolean isBomb,boolean isChecked, boolean isOpen, Field upperLeftField, Field upperField, Field upperRightField, Field leftField, Field rightField, Field bottomLeftField, Field bottomField, Field bottomRightField) {
        this.isBomb = isBomb;
        this.isChecked = isChecked;
        this.isOpen = isOpen;
        this.upperLeftField = upperLeftField;
        this.upperField = upperField;
        this.upperRightField = upperRightField;
        this.leftField = leftField;
        this.rightField = rightField;
        this.bottomLeftField = bottomLeftField;
        this.bottomField = bottomField;
        this.bottomRightField = bottomRightField;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Field getUpperLeftField() {
        return upperLeftField;
    }

    public Field getUpperField() {
        return upperField;
    }

    public Field getUpperRightField() {
        return upperRightField;
    }

    public Field getLeftField() {
        return leftField;
    }

    public Field getRightField() {
        return rightField;
    }

    public Field getBottomLeftField() {
        return bottomLeftField;
    }

    public Field getBottomField() {
        return bottomField;
    }

    public Field getBottomRightField() {
        return bottomRightField;
    }

    public void setNumberOfBombsInSurround(int numberOfBombsInSurround) {
        this.numberOfBombsInSurround = numberOfBombsInSurround;
    }

    public int getNumberOfBombsInSurround() {
        this.numberOfBombsInSurround = 0;
            if (this.upperLeftField != null) if (this.upperLeftField.isBomb) this.numberOfBombsInSurround++;
            if (this.upperField != null) if (this.upperField.isBomb) this.numberOfBombsInSurround++;
            if (this.upperRightField != null) this.numberOfBombsInSurround++;
            if (this.leftField != null) if (this.leftField.isBomb) this.numberOfBombsInSurround++;
            if (this.rightField != null) if (this.rightField.isBomb) this.numberOfBombsInSurround++;
            if (this.bottomLeftField != null) if (this.bottomLeftField.isBomb) this.numberOfBombsInSurround++;
            if (this.bottomField != null) if (this.bottomField.isBomb) this.numberOfBombsInSurround++;
            if (this.bottomRightField != null) if (this.bottomRightField.isBomb) this.numberOfBombsInSurround++;
        return numberOfBombsInSurround;
    }



    public String toString(){
        if(!this.isOpen) {
            if(!this.isChecked) return "#";
            else return "X";
        }
        else{
            if(this.isBomb) return "@";
            else{
                return String.valueOf(numberOfBombsInSurround);
            }
        }
    }

}
