package leetcode.tree;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {
    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            swap(data, i, k);

            printPermutations(data, n, k-1);

            swap(data, i, k);
        }
    }

    public static void swap(int[] data, int i, int k) {
        int tmp = data[i];
        data[i] = data[k-1];
        data[k-1] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        printPermutations(data, 3, 3);
    }
}
