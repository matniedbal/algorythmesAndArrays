package Sorting;

import java.util.Comparator;
import java.util.List;

public class SortInformationsTest<E> {

    private Sort<E> sort;
    private long duration;
    private String description;

    public SortInformationsTest(Sort<E> sort, List<E> toSort, Comparator<E> comparator) {
        this.sort = sort;
        this.duration = System.nanoTime()/1000;
        this.sort.sorting(toSort,comparator);
        this.duration = System.nanoTime()/1000 - this.duration ;
        this.description = sort.sortType();
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.description+"  Working time: "+this.duration;
    }
}
