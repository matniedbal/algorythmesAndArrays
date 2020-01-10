package Sorting;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortBySelect<E> implements Sort {

    boolean isNumeric = false;

    @Override
    public List sorting(List toSort, Comparator comparator) {
        if(toSort.get(0) instanceof Integer) this.isNumeric = true; else this.isNumeric = false;
        List<E> list = new LinkedList<>();
        for(Object el: toSort) list.add((E) el);
        int n = list.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = i +1; j < n; j++) {
                if (comparator.compare(list.get(i),list.get(j)) > 0) {
                    swap(i, j, list);
                }
            }
        }
        return list;
    }

    @Override
    public String sortType() {
        if(isNumeric) return "Sort by select, Integer list";
        else return "Sort by select, String list";
    }

}
