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

    public static int[] getArrayByNumberStream(String stream) {
        int[] arr = new int[stream.length()];
        int value = Integer.parseInt(stream);
        int mod = 0;
        for (int i = 0 ; i < stream.length() ; i++) {
            mod = value % 10;
            value -= mod;
            value /= 10;
            arr[i] = mod;
        }
        return arr;
    }
    
    public static int[] sortMergeArray(int[] arr) {
        if (arr.length < 2) {
            return arr; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayLeft = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrayLeft, 0, arr.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayRight = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrayRight, 0, arr.length - arr.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayLeft = sortMergeArray(arrayLeft); // левая часть возврат из рекурсии строкой return arr;
        arrayRight = sortMergeArray(arrayRight); // правая часть возврат из рекурсии строкой return arr;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayLeft, arrayRight);
    }

    private static int [] mergeArray(int [] arrayLeft, int [] arrayRight) {
        int[] arrayResult = new int[arrayLeft.length + arrayRight.length];
        int i = 0, j = 0;
        for (int k = 0; k < arrayResult.length; k++) {
            if (i > arrayLeft.length-1) {
                int a = arrayRight[j];
                arrayResult[k] = a;
                j++;
            }
            else if (j > arrayRight.length-1) {
                int a = arrayLeft[i];
                arrayResult[k] = a;
                i++;
            }
            else if (arrayLeft[i] < arrayRight[j]) {
                int a = arrayLeft[i];
                arrayResult[k] = a;
                i++;
            }
            else {
                int b = arrayRight[j];
                arrayResult[k] = b;
                j++;
            }
        }
        return arrayResult;
    }
}
