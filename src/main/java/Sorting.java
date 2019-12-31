import java.util.LinkedList;
import java.util.List;

public class Sorting<E> implements Comparable{

    public Sorting() {
    }

    public void bubbleSortInt(List<Integer> toSort){
        int n = toSort.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (toSort.get(j).compareTo(toSort.get(j + 1)) > 0)
                {
                    Integer temporary = toSort.get(j);
                    toSort.set(j,toSort.get(j+1));
                    toSort.set(j+1,temporary);
                }
    }

    public void bubbleSortString(List<String> toSort){
        int n = toSort.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (toSort.get(j).toUpperCase().compareTo(toSort.get(j + 1).toUpperCase()) > 0)
                {
                    String temporary = toSort.get(j);
                    toSort.set(j,toSort.get(j+1));
                    toSort.set(j+1,temporary);
                }
    }

    public void swap(int indexA1, int indexB1, List toSwap){
        E a2 = (E) toSwap.get(indexA1);
        E b2 = (E) toSwap.get(indexB1);

        toSwap.set(indexA1, b2);
        toSwap.set(indexB1, a2);

    }

    // TO REPAIR
    public void sortByChoice(List<Integer> toSort){
        int n = toSort.size();
            for (int i = 0; i < n - 1; i++) {
                int jMin = i;
                for (int j = i + 1; j < n; j++) {
                    if (toSort.get(i).compareTo(toSort.get(j)) > 0) {
                        jMin = j;
                    }
                    if (j != jMin) {
                        swap(i, jMin, toSort);
                    }
                }
            }
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
