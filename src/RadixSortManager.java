import java.util.*;
    public class RadixSortManager {
        static void arrayPrint(int arr[], int length)
        {
            for (int j = 0; j < length; j++){
                System.out.print(arr[j] + " ");}
        }
        static void digitSort(int mainArray[], int length, int exp)
        {
            int convertedArray[] = new int[length]; // output array
            int digitCount[] = new int[10];
            Arrays.fill(digitCount, 0);

            for (int j = 0; j < length; j++){
                digitCount[(mainArray[j] / exp) % 10]++;}

            for (int j = 1; j < 10; j++){
                digitCount[j] += digitCount[j - 1];}

            for (int j = length - 1; j >= 0; j--) {
                convertedArray[digitCount[(mainArray[j] / exp) % 10] - 1] = mainArray[j];
                digitCount[(mainArray[j] / exp) % 10]--;
            }
            for (int j = 0; j < length; j++){
                mainArray[j] = convertedArray[j];}
        }
        static void radixSorter(int arr[], int length)
        {
            int m = arrayMax(arr, length);
            for (int exp = 1; m / exp > 0; exp *= 10){
                digitSort(arr, length, exp);}
        }
        static int arrayMax(int arr[], int length)
        {
            int maxValue = arr[0];
            for (int j = 1; j < length; j++){
                if (arr[j] > maxValue){
                    maxValue = arr[j];}}
            return maxValue;
        }
        public static void main(String[] args)
        {
            int mainArray[] = { 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94 };
            int length = mainArray.length;
            radixSorter(mainArray, length);
            arrayPrint(mainArray, length);
        }
    }

