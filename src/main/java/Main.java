public class Main {

    public static void main (String ... args) {
        AlgorythmesAndArrays arrays = new AlgorythmesAndArrays(new Integer[]{1,2,4,5,7,9,11,14,16,24,26,30,33,34,39});
        System.out.print("My array: ");
        arrays.printArray(arrays.getArray(),false);
        System.out.print("Reversed: ");
        arrays.printArray(arrays.reversedArray(),false);
        System.out.print("Only even Index: ");
        arrays.printArray(arrays.evenIndexArray(),true);
        System.out.print("Only even Integers: ");
        arrays.printArray(arrays.returnEvenNumbersArray(),false);
    }
}