import java.util.LinkedList;
import java.util.List;

public class Sorting<E> implements Comparable{

    public Sorting() {
    }

    public void bubbleSortInt(List<Integer> toSort){
        int n = toSort.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (toSort.get(j).compareTo(toSort.get(j + 1)) > 0)
                {
                    Integer temporary = toSort.get(j);
                    toSort.set(j,toSort.get(j+1));
                    toSort.set(j+1,temporary);
                }
    }

    public void bubbleSortString(List<String> toSort){
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

    public void swap(int indexA1, int indexB1, List toSwap){
        E a2 = (E) toSwap.get(indexA1);
        E b2 = (E) toSwap.get(indexB1);

        toSwap.set(indexA1, b2);
        toSwap.set(indexB1, a2);

    }

    public void sortBySelectInt(List<Integer> toSort){
        int n = toSort.size();
            for (int i = 0; i < n -1; i++) {
                for (int j = i +1; j < n; j++) {
                    if (toSort.get(i).compareTo(toSort.get(j)) > 0) {
                        swap(i, j, toSort);
                    }
                }
            }
    }

    public void sortBySelectString(List<String> toSort){
        int n = toSort.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = i +1; j < n; j++) {
                if (toSort.get(i).compareTo(toSort.get(j)) > 0) {
                    swap(i, j, toSort);
                }
            }
        }
    }

    private List<Integer> quickSortList;

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
                quickSortList.addAll(listToSort);

            }
        }

    }

    public void quickSortInteger(List<Integer> toSort){
        quickSortList = new LinkedList<>();
        quicksortInteger(toSort);
        toSort.removeAll(toSort);
        toSort.addAll(quickSortList);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public enum sortType{
        bubbleSort,
        sortBySelect,
        quickSort,
        hybridSort;
    }

}
