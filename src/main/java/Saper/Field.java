package Saper;

public class Field {

    private boolean isBomb;
    private boolean isChecked;
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

    public void setiD(int iD) {
        this.iD = iD;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setNumberOfBombsInSurround(int numberOfBombsInSurround) {
        this.numberOfBombsInSurround = numberOfBombsInSurround;
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
