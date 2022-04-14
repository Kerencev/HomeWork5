import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {
        testTask1();

        Thing[] arr = new Thing[5];
        arr[0] = new Thing("Картина", 10, 10);
        arr[1] = new Thing("Ноутбук", 8, 7);
        arr[2] = new Thing("Телефон", 6, 5);
        arr[3] = new Thing("Телевизор", 12, 11);
        arr[4] = new Thing("Драгоценности", 15, 13);

        testTask2(arr);
    }

    private static void testTask1() {
        System.out.println(Number.raiseToDegree(3, -4));
    }

    private static void testTask2(Thing[] arr) {
        int[] weights = new int[arr.length];
        int[] prices = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            weights[i] = arr[i].getWeight();
            prices[i] = arr[i].getPrice();
        }

        int count = weights.length;
        int maxWeight = 20;

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, weights, count, maxWeight, result);

        int actualWeight = 0;
        int actualSum = 0;

        System.out.println("Оптимальное содержимое рюкзака:");
        for (Integer integer : result) {
            System.out.println(arr[integer - 1]);
            actualWeight += arr[integer - 1].getWeight();
            actualSum += arr[integer - 1].getPrice();
        }

        System.out.printf("\nМаксимальный вес: %d \nВес рюкзака: %d\n", maxWeight, actualWeight);
        System.out.println("Стоимость вещей: " + actualSum);
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }
}
