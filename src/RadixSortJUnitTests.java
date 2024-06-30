//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class RadixSortJUnitTests {
//
//    @Test
//    public void testRadixSort() {
//        // Test case 1: Basic sorting with positive integers
//        Integer[] arr1 = {170, 45, 75, 90, 802, 24, 1, 66, 2, 54};
//        Integer[] expected1 = {1, 2, 24, 45, 54, 66, 75, 90, 170, 802};
//        RadixSortManager.radixSorter(arr1, arr1.length);
//        assertArrayEquals(expected1, arr1);
//    }
//
//    @Test
//    public void testRadixSortNegativeIntegers() {
//        // Test case 2: Sorting with positive integers, negative integers, and 0
//        Integer[] arr2 = {-1, 5, 0, -10, 3, 45, -34, 4, -11, -39};
//        Integer[] expected2 = {-39, -34, -11, -10, -1, 0, 3, 4, 5, 45};
//        Integer[] negativeArray = RadixSortManager.negativeSeparator(arr2, arr2.length, true);
//        Integer[] nonNegativeArray = RadixSortManager.negativeSeparator(arr2, arr2.length, false);
//        arr2 = RadixSortManager.negMerge(nonNegativeArray, negativeArray);
//        assertArrayEquals(expected2, arr2);
//    }
//
//    @Test
//    public void testRadixSortDuplicateValues() {
//        // Test case 3: Sorting with duplicate values
//        Integer[] array = {5, 2, 8, 5, 3, 2, 1, 8, 2, 7};
//        Integer[] expected = {1, 2, 2, 2, 3, 5, 5, 7, 8, 8};
//        RadixSortManager.radixSorter(array, array.length);
//        assertArrayEquals(expected, array);
//    }
//}