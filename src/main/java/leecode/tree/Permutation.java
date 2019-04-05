package leecode.tree;

public class Permutation {
    public static void main(String[] args) {
        int[] data = {1, 2};
        printPermutations(data, 2, 2);
    }

    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k-1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
}
