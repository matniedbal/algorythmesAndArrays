package Sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort<E> implements Sort<E> {


    private long numberOfsearches;
    private boolean isNumeric = false;
    private SortType sortType = SortType.BubbleSort;

    @Override
    public <E> List<E> sorting(final List<E> toSort, Comparator<E> comparator) {
        numberOfsearches = 0;
        if(toSort.get(0) instanceof Integer) this.isNumeric = true; else this.isNumeric = false;
        List<E> list = new LinkedList<>();
        for(Object el: toSort) list.add((E) el);
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++) {
                numberOfsearches += 1;
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(j,j+1,list);
                }
            }
        return list;
    }

    @Override
    public String sortType() {
        if(isNumeric) return "Bubble sort, Integer list";
        else return "Bubble sort, String list";
    }

    @Override
    public SortType getSortType() {
        return this.sortType;
    }

    public long getNumberOfsearches() {
        return numberOfsearches;
    }
}
