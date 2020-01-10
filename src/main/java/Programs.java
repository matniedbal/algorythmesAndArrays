import org.apache.commons.lang3.RandomStringUtils;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.List;

public class Programs {


    public static void arrayListCheck(int numberOfElements, int quotient, int idOfValueToFind, int elementToRemove, int exist){
        long startTime;
        long endTime;
        long arraylistTime;
        System.out.println("\n\n***ARRAY_LIST***");
        Lista<Integer> lista = new ArrayList<>();

        startTime = System.nanoTime();
        for(int i = 1 ; i < numberOfElements; i++) lista.add(i*quotient);
        endTime = System.nanoTime();
        arraylistTime = (endTime - startTime);
        System.out.println("Czas działania arrayList add, dla "+numberOfElements+" elementów: "+arraylistTime);

        System.out.println("isEmpty: "+lista.isEmpty());
        System.out.println("ArrayList index "+idOfValueToFind+": "+lista.get(idOfValueToFind));
        System.out.println("ArrayList size: "+lista.size());
//        System.out.println(lista.toString());

        lista.remove(elementToRemove);
        System.out.println("remove "+elementToRemove);
//        System.out.println(lista.toString());
        System.out.println("ArrayList size: "+lista.size());

        startTime = System.nanoTime();
        System.out.println("ArrayList index "+idOfValueToFind+": "+lista.get(idOfValueToFind));
        endTime = System.nanoTime();
        arraylistTime = (endTime - startTime);
        System.out.println("Czas działania arrayList get, dla elementu "+idOfValueToFind+") id:: "+arraylistTime);

        System.out.println(exist+" exist? "+lista.exist(exist));
        System.out.println("IsSorted?: "+lista.isSorted((x,y)->1));
    }

    public static void linkedListCheck(int numberOfElements, int quotient, int idOfValueToFind, int elementToRemove, int exist){
        long startTime;
        long endTime;
        long linkedlistTime;
        System.out.println("\n\n***LINKED_LIST***");
        Lista<Integer> lista2 = (Lista<Integer>) new LinkedList<Integer>();

        startTime = System.nanoTime();
        for(int i = 1 ; i < numberOfElements; i++) lista2.add(i*quotient);
        endTime = System.nanoTime();
        linkedlistTime = (endTime - startTime);
        System.out.println("Czas działania linkedList add, dla "+numberOfElements+" elementów: "+linkedlistTime);

        System.out.println("isEmpty: "+lista2.isEmpty());
        System.out.println("LinkedList index "+idOfValueToFind+": "+lista2.get(idOfValueToFind));
//        System.out.println(lista2.toString());
        System.out.println("LinkedList size: "+lista2.size());

        startTime = System.nanoTime();
        System.out.println("LinkedList index "+idOfValueToFind+": "+lista2.get(idOfValueToFind));
        endTime = System.nanoTime();
        linkedlistTime = (endTime - startTime);
        System.out.println("Czas działania linkedList get, dla elementu "+idOfValueToFind+") id: "+linkedlistTime);

        lista2.remove(elementToRemove);
        System.out.println("remove "+elementToRemove);
//        System.out.println(lista2.toString());
        System.out.println("LinkedList size: "+lista2.size());
        System.out.println("LinkedList index "+idOfValueToFind+": "+lista2.get(idOfValueToFind));
        System.out.println(exist+" exist? "+lista2.exist(exist));
        System.out.println("IsSorted?: "+lista2.isSorted((x,y)->1));
    }

    public static void algorythmes(){
        long startTime;
        long endTime;
        long linearSearchTime;
        long binarySearchTime;
        long arraylistTime;
        long linkedlistTime;

        Search search = new Search();

        int arraySize = 129010056;
        int[] array = new int[arraySize];
        for (int i = 0 ; i < arraySize ; i ++){
           array[i] = i * 2;
        }

        AlgorythmesAndArrays arrays = new AlgorythmesAndArrays(new int[]{1, 2, 4, 5,1, 7, 9,1,1, 11, 14, 16, 24, 26, 30, 33, 34, 39,50});
        System.out.print("My array: ");
        arrays.printArray(arrays.getArray(), false);
        System.out.print("My sorted array: ");
        arrays.printArray(arrays.getSortedArray(), false);
        System.out.print("Reversed: ");
        arrays.printArray(arrays.reversedArray(), false);
        System.out.print("Only even Index: ");
        arrays.printArray(arrays.evenIndexArray(), true);
        System.out.print("Only even Integers: ");
        arrays.printArray(arrays.returnEvenNumbersArray(), false);
        int searched = 227010056;

        startTime = System.nanoTime();
        System.out.println("Linear search for number "+searched+": " + search.linearSearch(searched, array) + ", Number of searches: " + search.getLiearChecks());
        endTime = System.nanoTime();
        linearSearchTime = (endTime - startTime);
        startTime = System.nanoTime();
        System.out.println("Linear search for number "+searched+": " + search.binnarySearch(searched, array) + ", Number of searches: " + search.getBinaryChecks());
        endTime = System.nanoTime();
        binarySearchTime = (endTime - startTime);
        System.out.println("Linear time: "+linearSearchTime+"\nBinary time: "+binarySearchTime);
        int endNumber = 24;
        try {
            if(endNumber<2) throw new Prime_Numbers_List_Exception("No numbers in the list.");
            arrays.primaryNumbers(endNumber).stream().map(x -> x + ", ").forEach(System.out::print);

        } catch (Prime_Numbers_List_Exception ex){
            System.out.println(ex);
        }

        try {
            if(endNumber<0) throw new RecurtionNumberFormatException("No numbers in the list.");
            System.out.println("\nSum of all numbers form 0 to "+endNumber+" is: "+arrays.recurtionSum(endNumber));

        } catch (RecurtionNumberFormatException ex){
            System.out.println(ex);
        }

        System.out.println(arrays.numberOccurenceIndexesArray(arrays.getArray(),1));


    }

    public static void stock(int numberOfElements){

        Stock stock2 = new Stock();
        stock2.push("K");
        stock2.push("A");
        stock2.push("J");
        stock2.push("A");
        stock2.push("K");

        System.out.println(stock2.getTop().value);
        System.out.println(stock2.toString());
        System.out.println("Stock2 size: "+stock2.getStockSize());
        System.out.println("S2 is palindrome? "+stock2.isPalindrome());




    }

    public static void reversedPolishNotation(String string){
        ReversedPolishNotation RPN = new ReversedPolishNotation(string);
        System.out.println(RPN.toString());
    }

    public static void factorial(int number){
        Factorial factorial = new Factorial(number);
        System.out.println(factorial.getStock().toString()+" factorial is "+ factorial.result());
    }

    public static void queueCheck(int number){
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < number; i++) {
            queue.add(i);
        }

        System.out.println(queue.toString(true));
//        System.out.println(queue.getNodeByIndex(4).getValue());
        queue.remove(0);
        System.out.println(queue.toString(true));
//        queue.quit(9);
//        System.out.println(queue.toString(true));
    }

    public static void shop(int numberOfClients){
        Shop shop = new Shop(numberOfClients);
    }

    public static void sorting(){


        Gson gson = new Gson();

        int listLength = 1000;
        List<Integer> listIntToSort = new LinkedList<>();
        List<String> listStringToSort = new LinkedList<>();
        Sorting sort = new Sorting();
        for(int i = 0; i < listLength; i++){
           listIntToSort.add((int) (Math.random()*listLength));
        }
        for(int i = 0; i< listLength; i++){
            listStringToSort.add(RandomStringUtils.randomAlphabetic((int) ((Math.random()*((12-2)+1))+2)));
        }

        long startTime , endTime, totalTime;

        System.out.println(listIntToSort);
        System.out.println(listStringToSort);

        List<Integer> listIntToBubbleSort = listIntToSort;
        startTime = System.nanoTime();
        sort.sortInteger(listIntToBubbleSort, Sorting.SortType.bubbleSort);
        endTime = System.nanoTime();
        System.out.println("Bubble sort Integer List time: "+(endTime-startTime));


        List<String> listStringToBubbleSort = listStringToSort;
        startTime = System.nanoTime();
        sort.sortString(listStringToBubbleSort, Sorting.SortType.bubbleSort);
        endTime = System.nanoTime();
        System.out.println("Bubble sort String List time: "+(endTime-startTime));


        List<Integer> listIntToSelectSort = listIntToSort;
        startTime = System.nanoTime();
        sort.sortInteger(listIntToSelectSort, Sorting.SortType.sortBySelect);
        endTime = System.nanoTime();
        System.out.println("Sorting.Sort by select Integer List time: "+(endTime-startTime));


        List<String> listStringToSelectSort = listStringToSort;
        startTime = System.nanoTime();
        sort.sortString(listStringToSelectSort, Sorting.SortType.sortBySelect);
        endTime = System.nanoTime();
        System.out.println("Sorting.Sort by select String List time: "+(endTime-startTime));


        List<Integer> listIntToQuickSort = listIntToSort;
        startTime = System.nanoTime();
        sort.sortInteger(listIntToQuickSort, Sorting.SortType.quickSort);
        endTime = System.nanoTime();
        System.out.println("Quick sort Integer List time: "+(endTime-startTime));


        List<String> listStringToQuickSort = listStringToSort;
        startTime = System.nanoTime();
        sort.sortString(listStringToQuickSort, Sorting.SortType.quickSort);
        endTime = System.nanoTime();
        System.out.println("Quick sort String list time: "+(endTime-startTime));


        List<Integer> listIntToHybridSort1 = listIntToSort;
        startTime = System.nanoTime();
        sort.sortInteger(listIntToHybridSort1, Sorting.SortType.hybridSort);
        endTime = System.nanoTime();
        System.out.println("Hybrid sort Integer list time: "+(endTime-startTime));


        List<String> listStringToHybridSort1 = listStringToSort;
        startTime = System.nanoTime();
        sort.sortString(listStringToHybridSort1, Sorting.SortType.hybridSort);
        endTime = System.nanoTime();
        System.out.println("Hybrid sort String list time: "+(endTime-startTime));


        List<Integer> listIntToHybridSort2 = listIntToSort;
        startTime = System.nanoTime();
        sort.sortInteger(listIntToHybridSort2, Sorting.SortType.hybridSort,200);
        endTime = System.nanoTime();
        System.out.println("Hybrid sort with larger selection sort Integer list time: "+(endTime-startTime));


        List<String> listStringToHybridSort2 = listStringToSort;
        startTime = System.nanoTime();
        sort.sortString(listStringToHybridSort2, Sorting.SortType.hybridSort,200);
        endTime = System.nanoTime();
        System.out.println("Hybrid sort with larger selection sort String list time: "+(endTime-startTime));


    }

//    public static void sortMe(int numberOfItems){
//        int listLength = numberOfItems;
//        List<Integer> listIntToSort = new LinkedList<>();
//        List<String> listStringToSort = new LinkedList<>();
//        for(int i = 0; i < listLength; i++){
//            listIntToSort.add((int) (Math.random()*listLength));
//        }
//        for(int i = 0; i< listLength; i++){
//            listStringToSort.add(RandomStringUtils.randomAlphabetic((int) ((Math.random()*((12-2)+1))+2)));
//        }
//
//        Sort hybrid = new HybridSort(250);
//        Sort bubble = new BubbleSort();
//        Sort select = new SortBySelect<>();
//        Sort quick = new QuickSort();
//
//
//        System.out.println(listIntToSort);
//        System.out.println(bubble.sortedIntList(listIntToSort));
//        System.out.println(select.sortedIntList(listIntToSort));
//        System.out.println(quick.sortedIntList(listIntToSort));
//        System.out.println(hybrid.sortedIntList(listIntToSort));
//
//
//
//
//
//    }

}
