public class AlgorythmesAndArrays<E> {
    private E[] array;
    private int reversedArrCounter;
    private E[] reversedArray;
    public AlgorythmesAndArrays() {
    }
    public AlgorythmesAndArrays(E[] array) {
        this.array = array;
        this.reversedArrCounter = 0;
        this.reversedArray= (E[]) new Object[array.length];
    }
    public E[] getArray() {
        return array;
    }
    public E[] returnEvenNumbersArray() {
        int counter = 0;
        for (E el : this.array) {
            if ((Integer)el % 2 == 0) counter++;
        }
        E[] evenArray = (E[])new Object[counter];
        counter = 0;
        for (E el : this.array) {
            if ((Integer)el % 2 == 0) {
                evenArray[counter] = el;
                counter++;
            }
        }
        return evenArray;
    }
    public E[] evenIndexArray(){
        E[] evenIndexArr;
        if(this.array.length>2) {
            evenIndexArr = (E[]) new Object[this.array.length%2!=0 ? (this.array.length-1) / 2 : (this.array.length-2) / 2];
            int counter = 2;
            for (int i = 0 ; i< evenIndexArr.length; i++) {
                evenIndexArr[i] = this.array[counter];
                counter +=2;
                if(counter >= array.length) break;
            }
        }else{
            evenIndexArr = (E[]) new Object[1];
        }
        return evenIndexArr;
    }
    public E[] reversedArray(){
        if(this.reversedArrCounter >= this.array.length) return this.reversedArray;
        else {
            this.reversedArray[reversedArrCounter] = this.array[this.array.length-reversedArrCounter-1];
            this.reversedArrCounter ++;
            return reversedArray();
        }
    }
    public void printArray(E[] arrayToPrint, boolean index){
        int indexNo = 0;
        for(E el: arrayToPrint){
            if(!index) System.out.print(el.toString()+", ");
            else {
                System.out.print("("+indexNo+")" + el.toString() + ", ");
                indexNo++;
            }
        }
        System.out.println();
    }
}