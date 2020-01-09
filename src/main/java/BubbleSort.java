import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort implements Sort {

    public BubbleSort() {
    }

    @Override
    public List<Integer> sortedIntList(List<Integer> toSort) {
        List<Integer> list = new LinkedList<>();
        for(Integer el: toSort) list.add(el);
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Integer temporary = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temporary);
                }
        return list;
    }

    @Override
    public List<String> sortedStrList(List<String> toSort) {
        List<String> list = new LinkedList<>();
        for(String el: toSort) list.add(el);
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    String temporary = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temporary);
                }
        return list;
    }
}
