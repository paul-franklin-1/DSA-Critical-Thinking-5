import java.util.*;

public class RadixSortManager {

    /**
     * Prints array of Integer values.
     */
    static void arrayPrint(Integer[] mainArray, int length) {
        if (mainArray==null){
            System.out.println("mainArray cannot be null.");
        }
        for (int j = 0; j < length; j++) {
            System.out.print(mainArray[j] + " ");
        }
        System.out.println();
    }

    static void digitSort(Integer[] mainArray, int length, int exp) {
        if (mainArray==null){
            System.out.println("mainArray cannot be null.");
        }
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
    static void radixSorter(Integer[] array, int length) {
        if (array==null){
             System.out.println("Array cannot be null.");
        }
        int m = arrayMax(array, length);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            digitSort(array, length, exp);
        }
    }

    /**
     * Finds the maximum value in an array of Integer values.
     */
    static int arrayMax(Integer[] array, int length) {
        if (array==null){
            System.out.println("Array cannot be null.");
        }
        assert array != null;
        int maxValue = array[0];
        for (int j = 1; j < length; j++) {
            if (array[j] > maxValue) {
                maxValue = array[j];}
        }
        return maxValue;
    }
}