//import java.util.Arrays;
//
//public class SortingManager {
//    private Integer[] mainArray;
//    private Integer[] sortedArray;
//
//    // Constructor to initialize mainArray and sortedArray
//    public SortingManager(Integer[] mainArray) {
//        this.mainArray = mainArray;
//        this.sortedArray = new Integer[mainArray.length];
//    }


public class RadixSortNegativesManager {
    private static Integer[] negativeArray;
    private static Integer[] nonNegativeArray;

    public void negativeSeparator(Integer[] mainArray, int length) {
        int negativeCount = 0;
        Integer element = null;
        for (int i = 0; i < length; i++) {
            element = mainArray[i];
            if (element < 0) {
                negativeCount++;
            }
        }
        element = null;
        int p = 0;
        int q = 0;
        for (int i = 0; i < length; i++) {
            element = mainArray[i];
            if (element < 0) {
                negativeArray[p] = element * -1;
                p++;
            } else {
                nonNegativeArray[q] = element;
                q++;
            }
        }
    }

    public static Integer[] getNegativeArray() {
        return negativeArray;
    }

    public static Integer[] getNonNegativeArray() {
        return nonNegativeArray;
    }

    public static void sortNegatives() {
        int nonNegLength = nonNegativeArray.length;
        int negLength = negativeArray.length;
        RadixSortManager.radixSorter(nonNegativeArray, nonNegLength);
        RadixSortManager.radixSorter(negativeArray, negLength);
    }

        public static Integer[] mergeNegatives (){
            Integer[] mergedArray = new Integer[10];
            int negLength = negativeArray.length;
            int p = 0;
            for (int i = negLength - 1; i >= 0; i--) {
                mergedArray[p] = negativeArray[i] * -1;
                p++;
            }
           int nonNegLength = negativeArray.length;
            for (int i = 0; i < nonNegLength; i++) {
                mergedArray[p] = nonNegativeArray[i];
                nonNegLength++;
            }
            return mergedArray;
        }
    }