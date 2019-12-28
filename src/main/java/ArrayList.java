import java.util.Comparator;

public class ArrayList<E> implements Lista {

    E[] array;
    int arrayLength;


    public ArrayList() {
        this.arrayLength = 0;
        this.array = (E[]) new Object[arrayLength];
    }



    @Override
    public Object get(int index) {
        if(!isEmpty()) return array[index];
        else return null;
    }

    @Override
    public void add(Object elem) {
        E[] tempArr = (E[]) new Object[this.arrayLength+1];
        for(int i = 0; i<this.array.length;i++) tempArr[i] = array[i];
        tempArr[arrayLength] = (E) elem;
        this.arrayLength++;

        this.array = tempArr;
    }

    @Override
    public void remove(Object elem) {
        if(!isEmpty()) {

            E[] tempArr = (E[]) new Object[array.length - 1];
            boolean isPassed = false;
            if (exist(elem)) {
                array[getIndex(elem)] = null;
                for (int i = 0; i < tempArr.length; i++) {
                    if (!isPassed && this.array[i] != (null)) tempArr[i] = this.array[i];
                    else if (!isPassed && this.array[i] == (null)) {
                        isPassed = true;
                        tempArr[i] = this.array[i + 1];
                    } else if (isPassed && this.array[i] != (null)) tempArr[i] = this.array[i + 1];
                }
                this.array = tempArr;
            } else {
                System.out.println("Unable to find the Object");
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return array.length==0;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isSorted(Comparator comparator) {
        for (int i = 0; i < this.array.length-1; i++) {
            if(comparator.compare(array[i],array[i+1]) != 1) return false;
        }
        return true;
    }

    @Override
    public boolean exist(Object elem) {
        for(E el: this.array){
            if (el.equals(elem)) return true;
        }
        return false;
    }

    @Override
    public int getIndex(Object elem) throws NumberFormatException {

        int index = 0;
            for(E el: this.array) {
                if (el.equals(elem)) return index;
                index++;
            }
        return -1;

    }

    @Override
    public String toString() {
        String temp = "";
        if(!isEmpty()) {
            temp = "["+array[0]+", ";
            for (int i = 1; i < array.length-1; i++) {
                temp = temp + array[i]+", ";
            }
            if(array.length > 1) temp = temp+array[array.length-1]+"]";
            else temp = temp+"]";
        }
        return temp;
    }

    @Override
    public Object getFirstNode() {
        return null;
    }

    @Override
    public Object getLastNode() {
        return null;
    }
}


