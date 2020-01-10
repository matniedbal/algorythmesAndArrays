import java.util.List;

public class SortingResult<E> {

    private String description;
    private List<E> list;
    private SortType sortType;
    private long startTime;
    private long pendingTime;


    public long getPendingTime() {
        return pendingTime;
    }


    public enum SortType{
        BubbleSort,
        SelectSort,
        QuickSort,
        HybridSort;
    }

}

