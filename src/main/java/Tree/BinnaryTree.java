package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinnaryTree{

    int[] array;

    public BinnaryTree() {
        this.array = new int[]{9,8,7,5,6,5,6,4,3,1,2,1,3};
    }

    public int getRoot(){
        return array[0];
    }

    public int getRightChildOfRoot(){
        return array[2];
    }

    public int getLeftChildOfRoot(){
        return array[1];
    }

    public List getAllLeafs(){
        List temp = new LinkedList();
        for(int i = 0; i < this.array.length; i ++){
            if(2*i+1 > array.length-1 && 2*i+2 > array.length-1) temp.add(array[i]);
        }
        return temp;
    }

    public List getAllLeftChildren(){
        List temp = new LinkedList();
        for(int i = 0; i < this.array.length; i = 2*i+1) {
                temp.add(array[i]);
        }
        return temp;
    }

}
