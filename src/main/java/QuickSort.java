import java.util.LinkedList;
import java.util.List;

public class QuickSort implements Sort {

    private List<Integer> quickSortIntList;
    private List<String> quickSortStringList;

    public QuickSort() {
    }

    private void quicksortInteger(List<Integer> listToSort){
        if(listToSort.size()>0) {
            List<Integer> tempSmallerThanPivot = new LinkedList<>();
            List<Integer> tempEqualToPivot = new LinkedList<>();
            List<Integer> tempLargerThanPivot = new LinkedList<>();
            boolean isAllTheSame = true;
            for (int i = 0; i < listToSort.size() - 1; i++) {
                if (!listToSort.get(i).equals(listToSort.get(i + 1))) {
                    isAllTheSame = false;
                    break;
                }
                isAllTheSame = true;
            }

            if (listToSort.size()>1 && !isAllTheSame) {
                Integer pivot = listToSort.get(listToSort.size() - 1);

                for (Integer el : listToSort) {
                    if (el.compareTo(pivot) < 0) tempSmallerThanPivot.add(el);
                    else if (el.compareTo(pivot) == 0) tempEqualToPivot.add(el);
                    else if (el.compareTo(pivot) > 0) tempLargerThanPivot.add(el);
                }
                quicksortInteger(tempSmallerThanPivot);
                quicksortInteger(tempEqualToPivot);
                quicksortInteger(tempLargerThanPivot);
            } else {
                this.quickSortIntList.addAll(listToSort);

            }
        }

    }


    private void quicksortString(List<String> listToSort){
        if(listToSort.size()>0) {
            List<String> tempSmallerThanPivot = new LinkedList<>();
            List<String> tempEqualToPivot = new LinkedList<>();
            List<String> tempLargerThanPivot = new LinkedList<>();
            boolean isAllTheSame = true;
            for (int i = 0; i < listToSort.size() - 1; i++) {
                if (!listToSort.get(i).equalsIgnoreCase(listToSort.get(i + 1))) {
                    isAllTheSame = false;
                    break;
                }
                isAllTheSame = true;
            }

            if (listToSort.size()>1 && !isAllTheSame) {
                String pivot = listToSort.get(listToSort.size() - 1);

                for (String el : listToSort) {
                    if (el.compareToIgnoreCase(pivot) < 0) tempSmallerThanPivot.add(el);
                    else if (el.equalsIgnoreCase(pivot)) tempEqualToPivot.add(el);
                    else if (el.compareToIgnoreCase(pivot) > 0) tempLargerThanPivot.add(el);
                }
                quicksortString(tempSmallerThanPivot);
                quicksortString(tempEqualToPivot);
                quicksortString(tempLargerThanPivot);
            } else {
                this.quickSortStringList.addAll(listToSort);

            }
        }

    }



    @Override
    public List<Integer> sortedIntList(List<Integer> toSort) {
        this.quickSortIntList = new LinkedList<>();
        quicksortInteger(toSort);
        return this.quickSortIntList;
    }

    @Override
    public List<String> sortedStrList(List<String> toSort) {
        this.quickSortStringList = new LinkedList<>();
        quicksortString(toSort);
        return this.quickSortStringList;
    }
}
