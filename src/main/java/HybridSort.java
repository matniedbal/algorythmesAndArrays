import java.util.LinkedList;
import java.util.List;

public class HybridSort implements Sort {

    private int selectBySort_toHybrid_ArraySize;
    private Sort sortBySelect;
    private List<Integer> hybridSortIntList;
    private List<String> hybridSortStringList;

    public HybridSort(int selectBySort_toHybrid_ArraySize) {
        this.selectBySort_toHybrid_ArraySize = selectBySort_toHybrid_ArraySize;
        this.sortBySelect = new SortBySelect<>();
    }

    private void hybridSortInt(List<Integer> listToSort){
        if(listToSort.size()>0) {
            if (listToSort.size() > this.selectBySort_toHybrid_ArraySize) {
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
                if (listToSort.size() > 1 && !isAllTheSame) {
                    Integer pivot = listToSort.get(listToSort.size() - 1);
                    for (Integer el : listToSort) {
                        if (el.compareTo(pivot) < 0) tempSmallerThanPivot.add(el);
                        else if (el.compareTo(pivot) == 0) tempEqualToPivot.add(el);
                        else if (el.compareTo(pivot) > 0) tempLargerThanPivot.add(el);
                    }
                    hybridSortInt(tempSmallerThanPivot);
                    hybridSortInt(tempEqualToPivot);
                    hybridSortInt(tempLargerThanPivot);
                } else {
                    this.hybridSortIntList.addAll(listToSort);

                }
            } else {
                this.hybridSortIntList.addAll(this.sortBySelect.sortedIntList(listToSort));
            }
        }
    }


    private void hybridSortStr(List<String> listToSort){
        if(listToSort.size()>0) {
            if (listToSort.size() > this.selectBySort_toHybrid_ArraySize) {
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
                if (listToSort.size() > 1 && !isAllTheSame) {
                    String pivot = listToSort.get(listToSort.size() - 1);
                    for (String el : listToSort) {
                        if (el.compareToIgnoreCase(pivot) < 0) tempSmallerThanPivot.add(el);
                        else if (el.equalsIgnoreCase(pivot)) tempEqualToPivot.add(el);
                        else if (el.compareToIgnoreCase(pivot) > 0) tempLargerThanPivot.add(el);
                    }
                    hybridSortStr(tempSmallerThanPivot);
                    hybridSortStr(tempEqualToPivot);
                    hybridSortStr(tempLargerThanPivot);
                } else {
                    this.hybridSortStringList.addAll(listToSort);
                }
            } else {
                this.hybridSortStringList.addAll(this.sortBySelect.sortedStrList(listToSort));
            }
        }
    }


    @Override
    public List<Integer> sortedIntList(List<Integer> toSort) {
        this.hybridSortIntList = new LinkedList<>();
        hybridSortInt(toSort);
        return this.hybridSortIntList;
    }

    @Override
    public List<String> sortedStrList(List<String> toSort) {
        this.hybridSortStringList = new LinkedList<>();
        hybridSortStr(toSort);
        return this.hybridSortStringList;
    }
}
