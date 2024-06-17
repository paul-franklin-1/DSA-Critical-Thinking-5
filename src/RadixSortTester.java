/**
 * This class tests the functionality of Radix Sort implementation in RadixSortManager.
 * It creates an instance of RadixSortManager, initializes an array of integers,
 * sorts the array using radix sort, and prints the sorted array.
 */
public class RadixSortTester {
    /**
     * main method and test entry point
     * @param args
     */
    public static void main(String[] args) {
        RadixSortManager testMyRadix = new RadixSortManager();
        Integer mainArray[] = { 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94 };
        int length = mainArray.length;
        testMyRadix.radixSorter(mainArray, length);
        testMyRadix.arrayPrint(mainArray, length);
    }
}
