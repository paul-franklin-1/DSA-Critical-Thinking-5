import java.util.*;

public class RadixSortManager {

    /**
     * Prints array of Integer values.
     */
    static void arrayPrint(Integer mainArray[], int length) {
        for (int j = 0; j < length; j++) {
            System.out.print(mainArray[j] + " ");
        }
    }
    static Integer[] negativeSeparator(Integer[] integerArray, int length, boolean falseForNeg) {
        int negativeCount = 0;
        Integer element = null;
        for (int i = 0; i < length; i++) {
            element = integerArray[i];
            if (element < 0) {
                negativeCount++;
            }
        }
        Integer[] negativeList = new Integer[negativeCount];
        Integer[] nonNegativeList = new Integer[10 - negativeCount];
        element = null;
        int p = 0;
        int q = 0;
        for (int i = 0; i < length; i++) {
            element = integerArray[i];
            if (element < 0) {
                negativeList[p] = element * -1;
                p++;
            } else {
                nonNegativeList[q] = element;
                q++;
            }
        }
        if (falseForNeg){
            return negativeList;
        }
        else{return nonNegativeList;
        }
    }
    static void digitSort(Integer mainArray[], int length, int exp) {
        Integer[] convertedCount = new Integer[length]; // output array
        Integer[] digitCount = new Integer[10];
        Arrays.fill(digitCount, 0);

        for (int j = 0; j < length; j++) {
            digitCount[(mainArray[j] / exp) % 10]++;
        }

        for (int j = 1; j < 10; j++) {
            digitCount[j] += digitCount[j - 1];
        }

        for (int j = length - 1; j >= 0; j--) {
            convertedCount[digitCount[(mainArray[j] / exp) % 10] - 1] = mainArray[j];
            digitCount[(mainArray[j] / exp) % 10]--;
        }

        System.arraycopy(convertedCount, 0, mainArray, 0, length);
    }

    /**
     * Central radix sort method that uses int value returned by arrayMax method
     * and Integer array returned by digitSort method
     */
    static void radixSorter(Integer[] integerArray, int length) {
        int m = arrayMax(integerArray, length);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            digitSort(integerArray, length, exp);
        }
    }
    public static Integer[] negMerge (Integer[] nonNegativeList, Integer[] negativeList){
        Integer[] auxArray = new Integer[10];
        int nonNegLength = nonNegativeList.length;
        int negLength = negativeList.length;
        radixSorter(nonNegativeList, nonNegLength);
        radixSorter(negativeList, negLength);
        int p = 0;
        for (int i=negLength-1;i>=0;i--){
            auxArray[p] =negativeList[i]*-1;
            p++;
        }
        p = negLength;
        for(int i = 0;i<nonNegLength;i++) {
            auxArray[p] = nonNegativeList[i];
            p++;
        }
        return auxArray;
    }
    /**
     * Finds the maximum value in an array of Integer values.
     */
    static int arrayMax(Integer mainArray[], int length) {
        int maxValue = mainArray[0];
        for (int j = 1; j < length; j++) {
            if (mainArray[j] > maxValue) {
                maxValue = mainArray[j];}
        }
        return maxValue;
    }
}