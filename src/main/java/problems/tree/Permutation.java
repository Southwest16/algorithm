package problems.tree;

/**
 * 全排列
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        Permutation permutation = new Permutation();
        permutation.permute(data, 0, 2);
    }

    /**
     * permutation function
     *
     * @param data  string to calculate permutation for
     * @param l     starting index
     * @param r     end index
     */
    private void permute(int[] data, int l, int r) {
        if (l == r){
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        } else {
            for (int i = l; i <= r; i++) {
                swap(data, l, i);
                permute(data, l + 1, r);
                swap(data, l, i);
            }
        }
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}