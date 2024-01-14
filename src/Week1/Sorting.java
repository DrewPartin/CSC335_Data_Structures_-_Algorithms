package Week1;

import java.util.Arrays;

public class Sorting {
    static int sumOfFirstNIntegers(int[] array, int n) {
        // Base Case
        if (n == 0) {
            return 0;
        }
        // Recursive Case
        else {
            return array[n - 1] + sumOfFirstNIntegers(array, n - 1);
        }
    }

    //Binary Search Algorithm
    static int binarySearch(int[] array, int key, int low, int high) {
        // Base Case
        if (low > high) {
            return -1;
        }
        // Recursive Case
        else {
            int mid = (low + high) / 2;
            int midValue = array[mid];

            System.out.println("low: " + low + ", high: " + high + ", mid: " + mid + ", midValue: " + midValue);

            if (midValue == key) {
                return mid;
            }
            else if (midValue < key) {
                return binarySearch(array, key, mid + 1, high);
            }
            else {
                return binarySearch(array, key, low, mid - 1);
            }
        }
    }

    // Quick Sort Algorithm
    static void quickSort(int[] array, int low, int high) {
        // Base Case
        if (low >= high) {
            return;
        }
        // Recursive Case
        else {
            int pivot = array[(low + high) / 2];
            System.out.println("pivot: " + pivot);
            int index = partition(array, low, high, pivot);
            System.out.println("index: " + index);
            System.out.println("array: " + Arrays.toString(array));
            quickSort(array, low, index - 1);
            quickSort(array, index, high);
        }
    }

    static int partition(int[] array, int low, int high, int pivot) {
        while (low <= high) {
            while (array[low] < pivot) {
                low++;
            }
            while (array[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(array, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    // Merge Sort Algorithm
    static void mergeSort(int[] array, int low, int high) {
        // Base Case
        if (low >= high) {
            return;
        }
        // Recursive Case
        else {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
            System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
            System.out.println("array: " + Arrays.toString(array));
        }
    }

    static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            }
            else {
                temp[k] = array[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }
        System.arraycopy(temp, 0, array, low, temp.length);
    }

    // Radix Sort Algorithm
    static void radixSort(int[] array) {
        // Base Case
        if (array.length == 0) {
            return;
        }
        // Recursive Case
        else {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
                System.out.println("max: " + max + ", array[i]: " + array[i]);
                System.out.println("array: " + Arrays.toString(array));
            }

            for (int exp = 1; max / exp > 0; exp *= 10) {
                countSort(array, exp);
                System.out.println("exp: " + exp);
                System.out.println("array: " + Arrays.toString(array));
            }
        }
    }

    static void countSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

    // Shell Sort Algorithm
    static void shellSort(int[] array) {
        // Base Case
        if (array.length == 0) {
            return;
        }
        // Recursive Case
        else {
            int n = array.length;
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i++) {
                    int temp = array[i];
                    int j;
                    for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                        array[j] = array[j - gap];
                    }
                    array[j] = temp;
                    System.out.println("gap: " + gap + ", i: " + array[i] + ", j: " + array[j]);
                    System.out.println("array: " + Arrays.toString(array));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 4, 6, 2, 7};
        int f = 3;

        System.out.println("\nThe sum of the first " + f + " numbers in the array " + Arrays.toString(array) + " is: " + sumOfFirstNIntegers(array, f) + "\n");

        int[] array2 = {6, 12, 17, 23, 38, 45, 77, 84, 90};
        int key = 90;
        int low = 0;
        int high = array2.length - 1;

        System.out.println("\nThe index of the key " + key + " in the array " + Arrays.toString(array2) + " is: " + binarySearch(array2, key, low, high) + "\n");

        int[] array3 = new int[5000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i;
        }
        int key2 = 5001;
        int low2 = 0;
        int high2 = array3.length - 1;

        System.out.println("\nThe index of the key " + key2 + " in the array " + Arrays.toString(array3) + " is: " + binarySearch(array3, key2, low2, high2) + "\n");

        int[] array4 = {36, 41, 27, 12, 31, 17, 5};
        int low3 = 0;
        int high3 = array4.length - 1;

        System.out.println("\nQuick Sort on array " + Arrays.toString(array4) + " :\n");
        quickSort(array4, low3, high3);
        System.out.println("\nQuick Sort complete!\n");

        int[] array5 = {36, 14, 27, 12, 31, 17, 5};
        int low4 = 0;
        int high4 = array5.length - 1;

        System.out.println("\nMerge Sort on array " + Arrays.toString(array5) + ":\n");
        mergeSort(array5, low4, high4);
        System.out.println("\nMerge Sort complete!\n");

        int[] array6 = {36, 14, 27, 12, 31, 17, 5};

        System.out.println("\nRadix Sort on array " + Arrays.toString(array6) + ":\n");
        radixSort(array6);
        System.out.println("\nRadix Sort complete!\n");

        int[] array7 = {36, 14, 27, 12, 31, 17, 5};

        System.out.println("\nShell Sort on array " + Arrays.toString(array7) + ":\n");
        shellSort(array7);
        System.out.println("\nShell Sort complete!\n");
    }
}
