package sorts;
import java.util.Scanner;

/**
 *
 * @author elco45
 */
public class Sorts {
    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = menu();
            if (menu == 1) {

            } else if (menu == 2) {

            } else if (menu == 3) {

            } else if (menu == 4) {

            } else if (menu == 5) {

            } else if (menu == 6) {

            } else if (menu == 7) {

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
                    + "6. 1000000\n");
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
    
    
}
