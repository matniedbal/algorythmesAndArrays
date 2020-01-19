package Sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HybridSort<E,S> implements Sort<E> {

    private long numberOfsearches;
    boolean isNumeric = false;
    private int selectBySort_toHybrid_ArraySize;
    private Sort<E> sortBySelect;
    private List hybridSortList;
    private SortType sortType = SortType.HybridSort;

    public HybridSort(int selectBySort_toHybrid_ArraySize) {
        this.selectBySort_toHybrid_ArraySize = selectBySort_toHybrid_ArraySize;
    }

    private <E> void hybridSort(List<E> list, Comparator comparator){
        if(list.size()>0) {
            if (list.size() > this.selectBySort_toHybrid_ArraySize) {
                List<E> tempSmallerThanPivot = new LinkedList<>();
                List<E> tempEqualToPivot = new LinkedList<>();
                List<E> tempLargerThanPivot = new LinkedList<>();
                boolean isAllTheSame = true;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (comparator.compare(list.get(i),list.get(i + 1))!=0) {
                        isAllTheSame = false;
                        break;
                    }
                    isAllTheSame = true;
                }
                if (list.size() > 1 && !isAllTheSame) {
                    E pivot = list.get(list.size() - 1);
                    for (E el : list) {
                        if (comparator.compare(el, pivot) < 0) tempSmallerThanPivot.add(el);
                        else if (comparator.compare(el, pivot) == 0) tempEqualToPivot.add(el);
                        else if (comparator.compare(el, pivot) > 0) tempLargerThanPivot.add(el);
                    }
                    hybridSort(tempSmallerThanPivot, comparator);
                    hybridSort(tempEqualToPivot, comparator);
                    hybridSort(tempLargerThanPivot, comparator);
                } else {
                    this.hybridSortList.addAll(list);
                }
            } else {
                this.hybridSortList.addAll(this.sortBySelect.sorting(list, comparator));
            }
        }
    }

    @Override
    public <E> List<E> sorting(List<E> toSort, Comparator<E> comparator) {
        numberOfsearches = 0;
        if(toSort.get(0) instanceof Integer) this.isNumeric = true; else this.isNumeric = false;
        this.sortBySelect = new SortBySelect<>();
        this.hybridSortList = new LinkedList<>();
        hybridSort(toSort, comparator);
        return (List<E>) this.hybridSortList;
    }

    @Override
    public String sortType() {
        if(isNumeric) return "Hybrid sort with "+this.selectBySort_toHybrid_ArraySize+" sort by select array size, Integer list.";
        else return "Hybrid sort with "+this.selectBySort_toHybrid_ArraySize+" sort by select array size, String list.";
    }

    @Override
    public SortType getSortType() {
        return this.sortType;
    }
}
