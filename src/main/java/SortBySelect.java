import java.util.LinkedList;
import java.util.List;

public class SortBySelect<E> implements Sort {

    public SortBySelect() {
    }

    private void swap(int indexA1, int indexB1, List toSwap){
        E a2 = (E) toSwap.get(indexA1);
        E b2 = (E) toSwap.get(indexB1);

        toSwap.set(indexA1, b2);
        toSwap.set(indexB1, a2);

    }

    @Override
    public List<Integer> sortedIntList(List<Integer> toSort) {
        List<Integer> list = new LinkedList<>();
        for(Integer el: toSort) list.add(el);
        int n = list.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = i +1; j < n; j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    swap(i, j, list);
                }
            }
        }
        return list;
    }

    @Override
    public List<String> sortedStrList(List<String> toSort) {
        List<String> list = new LinkedList<>();
        for(String el: toSort) list.add(el);
        int n = list.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = i +1; j < n; j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    swap(i, j, list);
                }
            }
        }
        return list;
    }
}
