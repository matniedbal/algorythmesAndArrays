package Sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort implements Sort {

    boolean isNumeric = false;

    @Override
    public <E> List<E> sorting(final List<E> toSort, Comparator<E> comparator) {
        if(toSort.get(0) instanceof Integer) this.isNumeric = true; else this.isNumeric = false;
        List<E> list = new LinkedList<>();
        for(Object el: toSort) list.add((E) el);
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0)
                {
                    E temporary = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temporary);
                }
        return list;
    }

    @Override
    public String sortType() {
        if(isNumeric) return "Bubble sort, Integer list";
        else return "Bubble sort, String list";
    }


}
