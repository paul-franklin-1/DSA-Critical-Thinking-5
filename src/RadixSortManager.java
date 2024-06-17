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

    /**
     * Sorts an array of Integer values by sorting digits, starting with the least
     * significant digits and ending with the most significant digits
     */
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
    /**
     * Entry point of the program. Sorts an array of Integer values using Radix Sort
     * algorithm and prints the sorted array.
     */
    public static void main(String[] args) {
        Integer mainArray[] = { 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94 };
        int length = mainArray.length;
        radixSorter(mainArray, length);
        arrayPrint(mainArray, length);
    }
}