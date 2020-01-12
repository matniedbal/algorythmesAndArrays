package Sorting;

import java.util.Comparator;
import java.util.List;

public interface Sort<E> {

    <E> List<E> sorting(List<E> toSort, Comparator<E> comparator);

    String sortType();

    SortType getSortType();



    default <E> void swap(int indexA1, int indexB1, List<E> toSwap){
        E a2 = (E) toSwap.get(indexA1);
        E b2 = (E) toSwap.get(indexB1);

        toSwap.set(indexA1, b2);
        toSwap.set(indexB1, a2);
    }

    enum SortType{
        BubbleSort,
        SelectSort,
        QuickSort,
        HybridSort;
    }




}
