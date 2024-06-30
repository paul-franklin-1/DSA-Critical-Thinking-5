public class RadixSortNegativesManager {
    private static Integer[] negativeArray;
    private static Integer[] nonNegativeArray;

    public static void negativeSeparator(Integer[] mainArray, int length) {
        if (mainArray==null){
            System.out.println("mainArray cannot be null.");
        }
        negativeArray = new Integer[length];
        nonNegativeArray = new Integer[length];

        int negIndex = 0;
        int posIndex = 0;

        for (int i = 0; i < length; i++) {
            assert mainArray != null;
            if (mainArray[i] < 0) {
                negativeArray[negIndex++] = mainArray[i];
            } else {
                nonNegativeArray[posIndex++] = mainArray[i];
            }
        }
    }

    public static void sortNegatives() {
        RadixSortManager.radixSorter(negativeArray, negativeArray.length);
    }

    public static Integer[] mergeNegatives() {
        Integer[] mergedArray = new Integer[negativeArray.length + nonNegativeArray.length];

        int p = 0;

        for (int i = negativeArray.length - 1; i >= 0; i--) {
            mergedArray[p++] = negativeArray[i];
        }

        for (Integer integer : nonNegativeArray) {
            mergedArray[p++] = integer;
        }

        return mergedArray;
    }
}