package Sorting;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static <E> void main(String... agrs){

        int listLength = 10;
        int numberOfChecks = 10;
        List listToSortInteger = new LinkedList<>();
        List<String> listToSortString = new LinkedList<>();
        for(int i = 0; i < listLength; i++){
            listToSortInteger.add((int) (Math.random()*listLength/2));
        }
        for(int i = 0; i< listLength; i++){
            listToSortString.add(RandomStringUtils.randomAlphabetic((int) ((Math.random()*((12-2)+1))+2)));
        }

        List<SortInformationsTest<E>> sortInformationsTestList = new LinkedList<>();


        int counter=0;
        for(int i = 0 ; i < numberOfChecks ; i++){
            sortInformationsTestList.add(new SortInformationsTest<>(new QuickSort<>(), listToSortInteger, Integer::compareTo));
            for(int j = 20 ; j < 200; j+=20) {
                sortInformationsTestList.add(new SortInformationsTest<>(new HybridSort<>(j), listToSortInteger, Integer::compareTo));
            }
        }

        QuickSort quickSort = new QuickSort<SortInformationsTest>();
        List<SortInformationsTest> sortedList = (List<SortInformationsTest>) quickSort.sorting(sortInformationsTestList, new SortInfoComparator());

        System.out.println(listToSortInteger);
        System.out.println(quickSort.sorting(listToSortInteger,new SortInfoComparator()));
        System.out.println(sortedList.get(0).getDuration()+" "+sortedList.get(sortedList.size()-1).getDuration());
        System.out.println("The longest sorting of all types of sort was: " + sortInformationsTestList.stream().max(Comparator.comparing(x -> x.getDuration())).get().toString());
        System.out.println("The shortest sorting time of all types was: " + sortInformationsTestList.stream().min(Comparator.comparing(x -> x.getDuration())).get().toString());




    }

}
