package ua.com.alevel.nix.algorithm.util;

/**
 * @author Iehor Funtusov, created 01/07/2020 - 3:06 AM
 */
public class AlgorithmUtil {

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
