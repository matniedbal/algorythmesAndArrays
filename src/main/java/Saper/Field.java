package Saper;

public class Field {

    private boolean isBomb;
    private boolean isChecked;
    boolean isOpen;
    int numberOfBombsInSurround;

    public Field(boolean isBomb,boolean isChecked, boolean isOpen) {
        this.isBomb = isBomb;
        this.isChecked = isChecked;
        this.isOpen = isOpen;
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
            if(!this.isChecked) return "\u25A1";
            else return "X";
        }
        else{
            if(this.isBomb && !this.isChecked) return "\u25CF";
            else if(this.isBomb && this.isChecked) return "\u25CB";
            else{
                if(numberOfBombsInSurround==0) return ".";
                else return String.valueOf(numberOfBombsInSurround);
            }
        }
    }
}
