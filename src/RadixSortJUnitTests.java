import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadixSortJUnitTests {

    @Test
    public void testRadixSort() {
        RadixSortManager testMyRadix2 = new RadixSortManager();
        // Test case 1: Basic sorting with positive integers
        Integer[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66, 2, 54};
        Integer[] expected1 = {2, 2, 24, 45, 54, 66, 75, 90, 170, 802};
        RadixSortManager.radixSorter(arr1, 10);
        assertArrayEquals(expected1, arr1);
        RadixSortManager testMyRadix3 = new RadixSortManager();
        // Test case 2: Sorting with negative integers
        Integer[] arr2 = {-1, 5, 0, -10, 3, 45, -34, 5, -11, -39};
        Integer[] expected2 = {-45, -39, -34, -11, -10, -1, 0, 3, 5, 45};
        RadixSortManager.radixSorter(arr1, 10);
        assertArrayEquals(expected2, arr2);

        // Additional test cases for edge cases, empty array, etc.
    }
}
