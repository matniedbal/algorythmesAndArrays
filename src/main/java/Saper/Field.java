package Saper;

public class Field {

    private boolean isBomb;
    private boolean isChecked;
    boolean isOpen;
    int numberOfBombsInSurround;
    boolean isBlownBomb;

    public Field(boolean isBomb,boolean isChecked, boolean isOpen) {
        this.isBomb = isBomb;
        this.isChecked = isChecked;
        this.isOpen = isOpen;
        this.isBlownBomb = false;
    }

    public void setBlownBomb(boolean blownBomb) {
        isBlownBomb = blownBomb;
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
            if(this.isBomb && !this.isChecked && !this.isBlownBomb) return "\u25CF";
            else if(this.isBomb && this.isChecked && !this.isBlownBomb) return "\u25CB";
            else if(this.isBomb && !this.isChecked && this.isBlownBomb) return "\u2600";
            else{
                if(numberOfBombsInSurround==0) return ".";
                else return String.valueOf(numberOfBombsInSurround);
            }
        }
    }
}
