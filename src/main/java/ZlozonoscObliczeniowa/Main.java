package ZlozonoscObliczeniowa;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... arg){
//        long sumOfTimes = 0;
//        int numberOfChecks = 100000;
//        int firstNum = 9 , space = 9, numberOfNumbers = 1000;
//        long startTime, endTime;
//        for(int i = 0 ; i < numberOfChecks ; i ++){
//            startTime = System.nanoTime();
//            arithmeticStringSum(firstNum,space,numberOfNumbers);
//            endTime = System.nanoTime();
//            sumOfTimes += (endTime-startTime)/10;
//        }
//
//        System.out.println("Średnia: "+ sumOfTimes/numberOfChecks);

        int matrixElement = 0;
        int n = 4;
        Matrix matrix = new Matrix(n);
        System.out.println(matrix.sum());
        matrix.print();



    }

    static long arrayForEachTimeCheck (int numberOfElementsInArray){

        double[] arrayToCheck = new double[numberOfElementsInArray];
        long startTime = System.nanoTime();
        for(double element: arrayToCheck){
            element = 0;
            element += (Math.random()*numberOfElementsInArray);
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000;

    }

    static int arithmeticStringSum (int firstNumber, int space, int numberOfNumbers){
        int[] array = new int[numberOfNumbers];
        for(int i = 0; i < numberOfNumbers ; i ++ ){
            array[i] = firstNumber;
            firstNumber += space;
        }
        IntStream.range(firstNumber, numberOfNumbers).toArray();
        return ((array[0] + array[array.length-1])/2)*array.length;

    }

}
