import java.io.*;
import java.util.*;

    public class RadixSort {

        // A utility function to get maximum value in arr[]
        static int arrayMax(int arr[], int n)
        {
            int maxValue = arr[0];
            for (int j = 1; j < n; j++)
                if (arr[j] > maxValue)
                    maxValue = arr[j];
            return maxValue;
        }

        // A function to do counting sort of arr[] according to
        // the digit represented by exp.
        static void digitSort(int mainArray[], int n, int exp)
        {
            int convertedArray[] = new int[n]; // output array
            int i;
            int count[] = new int[10];
            Arrays.fill(count, 0);

            // Store count of occurrences in count[]
            for (int j = 0; j < n; j++)
                count[(mainArray[j] / exp) % 10]++;

            // Change count[i] so that count[i] now contains
            // actual position of this digit in output[]
            for (int j = 1; j < 10; j++)
                count[j] += count[j - 1];

            // Build the output array
            for (int j = n - 1; j >= 0; j--) {
                convertedArray[count[(mainArray[j] / exp) % 10] - 1] = mainArray[j];
                count[(mainArray[j] / exp) % 10]--;
            }

            // Copy the output array to arr[], so that arr[] now
            // contains sorted numbers according to current
            // digit
            for (int j = 0; j < n; j++)
                mainArray[j] = convertedArray[j];
        }

        // The main function to that sorts arr[] of
        // size n using Radix Sort
        static void radixSorter(int arr[], int n)
        {
            // Find the maximum number to know number of digits
            int m = arrayMax(arr, n);

            // Do counting sort for every digit. Note that
            // instead of passing digit number, exp is passed.
            // exp is 10^i where i is current digit number
            for (int exp = 1; m / exp > 0; exp *= 10)
                digitSort(arr, n, exp);
        }

        // A utility function to print an array
        static void arrayPrint(int arr[], int n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }

        // Main driver method
        public static void main(String[] args)
        {
            int arr[] = { 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94 };
            int n = arr.length;

            // Function Call
            radixSorter(arr, n);
            arrayPrint(arr, n);
        }
    }

