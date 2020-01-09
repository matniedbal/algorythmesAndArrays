import java.util.LinkedList;
import java.util.List;

public class Sorting<E> implements Comparable{

    public Sorting() {
    }

    private List<Integer> listCopyInt(List<Integer> toSort){
        List<Integer> listCopy = new LinkedList<>();
        for(Integer el: toSort) listCopy.add(el);
        return listCopy;
    }

    private List<String> listCopyString(List<String> toSort){
        List<String> listCopy = new LinkedList<>();
        for(String el: toSort) listCopy.add(el);
        return listCopy;
    }

    private void bubbleSortInt(List<Integer> toSort){
        List<Integer> list = new LinkedList<>();
        for(Integer el: toSort) list.add(el);
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j).compareTo(toSort.get(j + 1)) > 0)
                {
                    Integer temporary = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temporary);
                }
    }

    private void bubbleSortString(List<String> toSort){
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

    private void swap(int indexA1, int indexB1, List toSwap){
        E a2 = (E) toSwap.get(indexA1);
        E b2 = (E) toSwap.get(indexB1);

        toSwap.set(indexA1, b2);
        toSwap.set(indexB1, a2);

    }

    private void sortBySelectInt(List<Integer> toSort){
        int n = toSort.size();
            for (int i = 0; i < n -1; i++) {
                for (int j = i +1; j < n; j++) {
                    if (toSort.get(i).compareTo(toSort.get(j)) > 0) {
                        swap(i, j, toSort);
                    }
                }
            }
    }

    private void sortBySelectString(List<String> toSort){
        int n = toSort.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = i +1; j < n; j++) {
                if (toSort.get(i).compareTo(toSort.get(j)) > 0) {
                    swap(i, j, toSort);
                }
            }
        }
    }

    private List<Integer> quickSortIntList;
    private List<String> quickSortStringList;

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
                quickSortIntList.addAll(listToSort);

            }
        }

    }

    private void quickSortInteger(List<Integer> toSort){
        quickSortIntList = new LinkedList<>();
        quicksortInteger(toSort);
        toSort.removeAll(toSort);
        toSort.addAll(quickSortIntList);
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
                quickSortStringList.addAll(listToSort);

            }
        }

    }

    private void quickSortString(List<String> toSort){
        quickSortStringList = new LinkedList<>();
        quicksortString(toSort);
        toSort.removeAll(toSort);
        toSort.addAll(quickSortStringList);
    }

    private List<Integer> hybridSortIntList;
    private List<String> hybridSortStringList;

    private void hybridSortInt(List<Integer> listToSort, int selectSortArraySize){
        if(listToSort.size()>0) {
            if (listToSort.size() > selectSortArraySize) {
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
                    hybridSortInt(tempSmallerThanPivot,selectSortArraySize);
                    hybridSortInt(tempEqualToPivot,selectSortArraySize);
                    hybridSortInt(tempLargerThanPivot,selectSortArraySize);
                } else {
                    hybridSortIntList.addAll(listToSort);

                }
            } else {
                sortBySelectInt(listToSort);
                hybridSortIntList.addAll(listToSort);
            }
        }
    }

    private void hybridSortInteger(List<Integer> toSort, int selectSortArraySize){
        hybridSortIntList = new LinkedList<>();
        hybridSortInt(toSort, selectSortArraySize);
        toSort.removeAll(toSort);
        toSort.addAll(hybridSortIntList);
    }

    private void hybridSortStr(List<String> listToSort, int selectSortArraySize){
        if(listToSort.size()>0) {
            if (listToSort.size() > selectSortArraySize) {
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
                    hybridSortStr(tempSmallerThanPivot,selectSortArraySize);
                    hybridSortStr(tempEqualToPivot,selectSortArraySize);
                    hybridSortStr(tempLargerThanPivot,selectSortArraySize);
                } else {
                    hybridSortStringList.addAll(listToSort);
                }
            } else {
                sortBySelectString(listToSort);
                hybridSortStringList.addAll(listToSort);
            }
        }
    }

    private void hybridSortString(List<String> toSort, int selectSortArraySize){
        hybridSortStringList = new LinkedList<>();
        hybridSortStr(toSort, selectSortArraySize);
        toSort.removeAll(toSort);
        toSort.addAll(hybridSortStringList);
    }

    public void sortInteger(List<Integer> listToSort, SortType sortType){
        if(sortType == SortType.bubbleSort)
            bubbleSortInt(listToSort);
        else if(sortType == SortType.sortBySelect)
            sortBySelectInt(listToSort);
        else if(sortType == SortType.quickSort)
            quickSortInteger(listToSort);
        else if(sortType == SortType.hybridSort)
            hybridSortInteger(listToSort,50);
    }

    public void sortInteger(List<Integer> listToSort, SortType sortType, int selectSortArraySizeInHybridSorting){
        if(sortType == SortType.bubbleSort)
            bubbleSortInt(listToSort);
        else if(sortType == SortType.sortBySelect)
            sortBySelectInt(listToSort);
        else if(sortType == SortType.quickSort)
            quickSortInteger(listToSort);
        else if(sortType == SortType.hybridSort)
            hybridSortInteger(listToSort,selectSortArraySizeInHybridSorting);
    }

    public void sortString(List<String> listToSort, SortType sortType){
        if(sortType == SortType.bubbleSort)
            bubbleSortString(listToSort);
        else if(sortType == SortType.sortBySelect)
            sortBySelectString(listToSort);
        else if(sortType == SortType.quickSort)
            quickSortString(listToSort);
        else if(sortType == SortType.hybridSort)
            hybridSortString(listToSort,50);
    }

    public void sortString(List<String> listToSort, SortType sortType, int selectSortArraySizeInHybridSorting){
        if(sortType == SortType.bubbleSort)
            bubbleSortString(listToSort);
        else if(sortType == SortType.sortBySelect)
            sortBySelectString(listToSort);
        else if(sortType == SortType.quickSort)
            quickSortString(listToSort);
        else if(sortType == SortType.hybridSort)
            hybridSortString(listToSort,selectSortArraySizeInHybridSorting);
    }

    public int compareTo(Object o) {
        return 0;
    }


    public enum SortType{
        bubbleSort,
        sortBySelect,
        quickSort,
        hybridSort;
    }
}
