package Sorting;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    public static <E> void main(String... agrs){

        int listLength = 20000;
        List listToSortInteger = new LinkedList<>();
        List<String> listToSortString = new LinkedList<>();
        for(int i = 0; i < listLength; i++){
            listToSortInteger.add((int) (Math.random()*listLength/2));
        }
        for(int i = 0; i< listLength; i++){
            listToSortString.add(RandomStringUtils.randomAlphabetic((int) ((Math.random()*((12-2)+1))+2)));
        }

        int n = 0;
        List<Sort> sorts = new LinkedList<>();
        for(int i = 0 ; i < 300; i += 2){
            sorts.add(new HybridSort<>(i));
        }

        System.out.println("Unsorted Integer list:\n"+listToSortInteger+"\nUnsorted String list:\n"+listToSortString+"\n");

        long startT;
        for(Sort el: sorts){
            startT = System.nanoTime();
            el.sorting(listToSortInteger, Integer::compareTo);
            System.out.println(el.sortType()+"    Working time: "+(System.nanoTime()-startT)/100000);
//            startT = System.nanoTime();
//            System.out.println(el.sorting(listToSortString, String::compareTo));
//            System.out.println(el.sortType()+"    Working time: "+(System.nanoTime()-startT));

        }

    }

}
