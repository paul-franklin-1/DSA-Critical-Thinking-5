import java.util.Scanner;

/**
 * This class tests the functionality of Radix Sort implementation in RadixSortManager.
 * It creates an instance of RadixSortManager, initializes an array of integers,
 * sorts the array using radix sort, and prints the sorted array.
 */
public class RadixSortTester {
    private static boolean containsNegatives;
    private static Integer[] finalArray;

    /**
     * main method and test entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] mainArray = new Integer[10];
        Integer[] mainArrayCopy = new Integer[10];
        int length = mainArray.length;
        System.out.println("Enter an array of 10 Integers:");
        while (true) {
            try (Scanner scnr = new Scanner(System.in)) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Enter value #" + (i + 1) + ":\n");
                    String scannedValue = scnr.nextLine();
                    Integer newElement = Integer.valueOf(scannedValue);
                    mainArray[i] = newElement;
                }
            }
            if (mainArray == null) {
                System.out.println("Alert: Your main array cannot be null.");
            }
            else if (mainArray.length == 0) {
                System.out.println("Alert: Your main array cannot be empty.");
            }
            else {
                break;
            }
        }
        mainArrayCopy = mainArray;
        containsNegatives = false;
        for (int i = 0; i < length; i++) {
            if (mainArray[i] < 0) {
                containsNegatives = true;
                break;
            }
        }
        if (containsNegatives) {
            RadixSortNegativesManager.negativeSeparator(mainArray, length);
            RadixSortNegativesManager.sortNegatives();
            finalArray = RadixSortNegativesManager.mergeNegatives();
            System.out.print("Unsorted array: ");
            RadixSortManager.arrayPrint(mainArrayCopy, length);
            System.out.print("Sorted array: ");
            RadixSortManager.arrayPrint(finalArray, length);
        } else {
            RadixSortManager.radixSorter(mainArray, length);
            System.out.print("Unsorted array: ");
            RadixSortManager.arrayPrint(mainArrayCopy, length);
            System.out.print("Sorted array: ");
            RadixSortManager.arrayPrint(mainArray, length);
        }
    }
}

