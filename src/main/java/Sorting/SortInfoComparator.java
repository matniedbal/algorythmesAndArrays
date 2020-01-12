package Sorting;

import java.util.Comparator;

public class SortInfoComparator implements Comparator<SortInformationsTest> {
    @Override
    public int compare(SortInformationsTest sortInformationsTest, SortInformationsTest t1) {
        if(sortInformationsTest.getDuration() < t1.getDuration()) return -1;
        else if(sortInformationsTest.getDuration() == t1.getDuration()) return 0;
        else  return 1;

    }


}
