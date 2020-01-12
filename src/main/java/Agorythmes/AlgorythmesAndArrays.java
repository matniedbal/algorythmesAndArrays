package Agorythmes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AlgorythmesAndArrays<E> {
    private int[] array;
    private int reversedArrCounter;
    private int[] reversedArray;
    public AlgorythmesAndArrays() {
    }
    public AlgorythmesAndArrays(int[] array) {
        this.array = array;
        this.reversedArrCounter = 0;
        this.reversedArray=  new int[array.length];
    }
    public int[] getArray() {
        return array;
    }

    public int[] getSortedArray() {
        return Arrays.stream(array).sorted().toArray();
    }

    public int[] returnEvenNumbersArray() {
        int counter = 0;
        for (int el : this.array) {
            if (el % 2 == 0) counter++;
        }
        int[] evenArray = new int[counter];
        counter = 0;
        for (int el : this.array) {
            if (el % 2 == 0) {
                evenArray[counter] = el;
                counter++;
            }
        }
        return evenArray;
    }
    public int[] evenIndexArray(){
        int[] evenIndexArr;
        if(this.array.length>2) {
            evenIndexArr = new int[this.array.length%2!=0 ? (this.array.length-1) / 2 : (this.array.length-2) / 2];
            int counter = 2;
            for (int i = 0 ; i< evenIndexArr.length; i++) {
                evenIndexArr[i] = this.array[counter];
                counter +=2;
                if(counter >= array.length) break;
            }
        }else{
            evenIndexArr =  new int[1];
        }
        return evenIndexArr;
    }
    public int[] reversedArray(){
        if(this.reversedArrCounter >= this.array.length) return this.reversedArray;
        else {
            this.reversedArray[reversedArrCounter] = this.array[this.array.length-reversedArrCounter-1];
            this.reversedArrCounter ++;
            return reversedArray();
        }
    }
    public void printArray(int[] arrayToPrint, boolean index){
        int indexNo = 0;
        for(int el: arrayToPrint){
            if(!index) System.out.print(el+", ");
            else {
                System.out.print("("+indexNo+")" + el + ", ");
                indexNo++;
            }
        }
        System.out.println();
    }

    private boolean isPrimary(int Number){
        for(int i = 2 ; i <= Number/2; i++){
            if (Number%i==0) return false;
        }
        return true;
    }

    public List<Integer> primaryNumbers(int lastPrimary) throws Prime_Numbers_List_Exception {
        List<Integer> list = new LinkedList<Integer>();
        int counter = 2;
        while (counter<=lastPrimary){
            if (isPrimary(counter)) list.add(counter);
            counter++;
        }
        return list;
    }

    private int recurtionSum = 0;

    public int recurtionSum (int n) throws RecurtionNumberFormatException{
        if (n == 0) return this.recurtionSum;
        else {
            this.recurtionSum += n;
            return recurtionSum(n-1);
        }
    }

    public List numberOccurenceIndexesArray (int[] array, int number){
        List list = new LinkedList();
        int counter = 0;
        for(int el: array){
            if(el == number) list.add(counter);
            counter++;
        }
        return list;

    }

    public void printList(List list){
        list.stream().map(x->x+", ").forEach(System.out::print);
        System.out.println();
    }




}