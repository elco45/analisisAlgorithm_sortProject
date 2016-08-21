package sorts;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author elco45
 */
public class Sorts {

    private static int N;

    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = menu();
            if (menu != 8) {
                printResult(menu);
            } else {
                break;
            }
        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int resp = 0;
        while (true) {
            System.out.println("1. Bubble Sort\n"
                    + "2. Selection Sort\n"
                    + "3. Insertion Sort\n"
                    + "4. Heap Sort\n"
                    + "5. Merge Sort\n"
                    + "6. Radix Sort\n"
                    + "7. Quick Sort\n"
                    + "8. Exit");
            resp = sc.nextInt();
            if (resp >= 1 && resp <= 8) {
                return resp;
            } else {
                System.err.println("Error");
            }
        }
    }

    public static int submenu() {
        Scanner sc = new Scanner(System.in);
        int resp = 0;
        while (true) {
            System.out.println("1. 10\n"
                    + "2. 100\n"
                    + "3. 1000\n"
                    + "4. 10000\n"
                    + "5. 100000\n"
                    + "6. 1000000");
            resp = sc.nextInt();
            if (resp == 1) {
                return 10;
            } else if (resp == 2) {
                return 100;
            } else if (resp == 3) {
                return 1000;
            } else if (resp == 4) {
                return 10000;
            } else if (resp == 5) {
                return 100000;
            } else if (resp == 6) {
                return 1000000;
            } else {
                System.err.println("Error");
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] createArray() {
        Random rand = new Random();
        int[] array = new int[submenu()];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000000);
        }
        return array;
    }

    public static void printResult(int alg) {
        long cont;
        int[] tmp = createArray();
        if (alg == 1) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                bubbleSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }
        } else if (alg == 2) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                selectionSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }

        } else if (alg == 3) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                insertionSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }

        } else if (alg == 4) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                heapSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }

        } else if (alg == 5) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                mergeSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }

        } else if (alg == 6) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                radixSort(tmp);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }
        } else if (alg == 7) {
            for (int i = 0; i < 10; i++) {
                shuffleArray(tmp);
                cont = System.nanoTime();
                quickSort(tmp, 0, tmp.length - 1);
                System.out.println((double) (System.nanoTime() - cont) / 1000000000);
            }
        }
        System.out.println("");
    }

    public static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    //http://stackoverflow.com/questions/16088994/sorting-an-array-of-int-using-bubblesort
    public static void bubbleSort(int[] numArray) {
        int n = numArray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (numArray[j - 1] > numArray[j]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }

            }
        }
    }

    //http://stackoverflow.com/questions/8362640/java-selection-sort-algorithm
    public static void selectionSort(int[] input) {
        int minimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; ++i) {
            for (int j = i; j < input.length; ++j) {
                if (input[j] <= minimumValue) {
                    minimumValue = input[j];
                    input[j] = input[i];
                    input[i] = minimumValue;
                }
            }
            minimumValue = Integer.MAX_VALUE;
        }
    }

    //http://www.journaldev.com/585/insertion-sort-in-java
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }

    //http://www.sanfoundry.com/java-program-implement-heap-sort/
    public static void heapSort(int arr[]) {
        heapify(arr);
        for (int i = N; i > 0; i--) {
            swap(arr, 0, i);
            N = N - 1;
            maxheap(arr, 0);
        }
    }

    public static void heapify(int arr[]) {
        N = arr.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            maxheap(arr, i);
        }
    }

    public static void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i]) {
            max = left;
        }
        if (right <= N && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //http://stackoverflow.com/questions/13727030/mergesort-in-java
    public static void mergeSort(int[] in) {
        if (in.length < 2) {
            return; //do not need to sort
        }
        int mid = in.length / 2;
        int left[] = new int[mid];
        int right[] = new int[in.length - mid];
        for (int i = 0; i < mid; i++) { //copy left
            left[i] = in[i];
        }
        for (int i = 0; i < in.length - mid; i++) { //copy right
            right[i] = in[mid + i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, in);
    }

    private static void merge(int[] a, int[] b, int[] all) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) { //merge back
            if (a[i] < b[j]) {
                all[k] = a[i];
                i++;
            } else {
                all[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) { //left remaining
            all[k++] = a[i++];
        }
        while (j < b.length) { //right remaining
            all[k++] = b[j++];
        }
    }

    //https://rosettacode.org/wiki/Sorting_algorithms/Radix_sort
    public static void radixSort(int[] old) {
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            int[] tmp = new int[old.length];
            int j = 0;
            for (int i = 0; i < old.length; i++) {
                boolean move = old[i] << shift >= 0;
                if (shift == 0 ? !move : move) {
                    tmp[j] = old[i];
                    j++;
                } else {
                    old[i - j] = old[i];
                }
            }
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = old[i - j];
            }
            old = tmp;
        }
    }

    //http://www.programcreek.com/2012/11/quicksort-array-in-java/
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

}
