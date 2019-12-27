import java.util.FormatFlagsConversionMismatchException;

public class Main {

    public static void main(String... args)  {

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
        long startTime;
        long endTime;
        long linearSearchTime;
        long binarySearchTime;

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
        System.out.println("\n\nARRAY_LIST\n");

        int numberOfElements = 40;
        int quotient = 3;
        Lista<Integer> lista = new ArrayList<>();
        for(int i = 0 ; i < numberOfElements; i++) lista.add(i*quotient);

        System.out.println("ArrayList: "+" size: "+lista.size());

        Lista<Integer> lista2 = new LinkedList<>();
//        lista2.add(1);
//        lista2.add(2);
//        lista2.add(3);
//        lista2.add(4);
//        lista2.add(5);

        for(int i = 0 ; i < numberOfElements; i++) lista2.add(i*quotient);
        System.out.println("LinkedList: "+" size: "+lista2.size());


//        int id = 20;
//        System.out.println("ArrayList index "+id+": "+lista.get(id));
//        System.out.println("LinkedList index "+id+": "+lista2.get(id));
        System.out.println(lista2.toString());
        System.out.println("LinkedList index "+0+": "+lista2.get(0));

        lista2.remove(0);
        System.out.println(lista2.toString());
        System.out.println("LinkedList: "+" size: "+lista2.size());
        System.out.println("LinkedList index "+0+": "+lista2.get(0));
    }
}