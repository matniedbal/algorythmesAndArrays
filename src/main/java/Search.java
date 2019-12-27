import java.util.LinkedList;
import java.util.List;

public class Search <E> {

    public Search() {
    }


    private int liearChecks = 0;
    private int binaryChecks = 0;



    public boolean binnarySearch(int searchedElement, int[] searchedArray) throws NumberFormatException{

        if(searchedArray.length == 0) return false;

        binaryChecks++;
        int pinIndex = searchedArray.length/2;
        int[] tempArray;
        int startIndex = 0;
        int endIndex = searchedArray.length-1;

        if(searchedArray[pinIndex] == searchedElement
                || searchedElement == searchedArray[startIndex]
                || searchedElement == searchedArray[endIndex])
            return true;

        if(searchedArray.length ==1 && searchedArray[pinIndex]!= searchedElement
                || searchedElement < searchedArray[startIndex]
                || searchedElement > searchedArray[endIndex]) return false;

        if(searchedArray[pinIndex] > searchedElement ){
            startIndex = 1;
            endIndex = pinIndex-1;
            tempArray = new int[pinIndex-1];
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = searchedArray[i+startIndex];
            }
            return binnarySearch(searchedElement, tempArray);
        }else {
            startIndex = pinIndex+1;
            endIndex = searchedArray.length - 2;
            tempArray = new int[endIndex - startIndex+1];
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = searchedArray[startIndex];
                startIndex++;
            }
            return binnarySearch(searchedElement, tempArray);
        }
    }

    public boolean linearSearch(int searchedElement, int[] searchedArray){
        this.liearChecks = 0;
        for(int el: searchedArray){
            liearChecks++;
            if(el == searchedElement) return true;
            if(el > searchedElement) return false;
        }
        return false;
    }


    public int getLiearChecks() {
        return liearChecks;
    }

    public int getBinaryChecks() {
        return binaryChecks;
    }





}
