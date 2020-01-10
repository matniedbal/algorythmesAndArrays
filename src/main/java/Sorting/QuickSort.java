package Sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QuickSort<E> implements Sort {

    boolean isNumeric = false;
    private List<E> quickSortList;

    private void quickSort(List<E> listToSort, Comparator comparator){
        if(listToSort.size()>0) {
            List<E> tempSmallerThanPivot = new LinkedList<>();
            List<E> tempEqualToPivot = new LinkedList<>();
            List<E> tempLargerThanPivot = new LinkedList<>();
            boolean isAllTheSame = true;
            for (int i = 0; i < listToSort.size() - 1; i++) {
                if (!listToSort.get(i).equals(listToSort.get(i + 1))) {
                    isAllTheSame = false;
                    break;
                }
                isAllTheSame = true;
            }

            if (listToSort.size()>1 && !isAllTheSame) {
                E pivot = listToSort.get(listToSort.size() - 1);

                for (E el : listToSort) {
                    if (comparator.compare(el, pivot) < 0) tempSmallerThanPivot.add(el);
                    else if (comparator.compare(el, pivot) == 0) tempEqualToPivot.add(el);
                    else if (comparator.compare(el, pivot) > 0) tempLargerThanPivot.add(el);
                }
                quickSort(tempSmallerThanPivot, comparator);
                quickSort(tempEqualToPivot, comparator);
                quickSort(tempLargerThanPivot, comparator);
            } else {
                this.quickSortList.addAll(listToSort);

            }
        }

    }


    @Override
    public List sorting(final List toSort, Comparator comparator) {
        if(toSort.get(0) instanceof Integer) this.isNumeric = true; else this.isNumeric = false;
        this.quickSortList = new LinkedList<>();
        quickSort(toSort, comparator);
        return this.quickSortList;
    }

    @Override
    public String sortType() {
        if(isNumeric) return "Quick sort, Integer List";
        else return "Quick sort, String List";
    }



}