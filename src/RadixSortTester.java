import java.util.Scanner;

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
        Integer[] mainArray = new Integer[10];
        int length = mainArray.length;
        boolean x = true;
        System.out.println("Enter an array of 10 Integers:");
        while(x){
            try (Scanner scnr = new Scanner(System.in)) {
                for (int i = 0; i < 10; i++){
                    System.out.println("Enter value #" + (i+1) + ":\n");
                    String scannedValue = scnr.nextLine();
                    Integer newElement = Integer.valueOf(scannedValue);
                    mainArray[i] = newElement;
                }
            }
            if (mainArray == null) {
                System.out.println("Alert: Your main array cannot be null.");
                continue;
            }
            else if (mainArray.length == 0) {
                System.out.println("Alert: Your main array cannot be empty.");
                continue;
            }
            else {
                x = false;
            }
        }
        Integer[] negativeList = RadixSortManager.negativeSeparator(mainArray,length,false);
        Integer[] nonNegativeList = RadixSortManager.negativeSeparator(mainArray,length,true);
        Integer[] finalArray = new Integer[10];
        finalArray = RadixSortManager.negMerge(nonNegativeList, negativeList);
        System.out.print("Unsorted array: ");
        RadixSortManager.arrayPrint(mainArray, length);
        System.out.println();
        System.out.print("Sorted array: ");
        RadixSortManager.arrayPrint(finalArray, length);
    }
}
