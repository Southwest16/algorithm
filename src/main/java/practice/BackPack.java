package practice;

public class BackPack {
    private int[] weight = {2, 2, 4, 6, 3};
    private int n = weight.length;
    private int max = 9;
    private int result = Integer.MIN_VALUE;
    private boolean[][] mem = new boolean[n][max];

    public void backpack(int i, int curr) {
        if (i == n || curr == max) {
            if (curr > result) result = curr;
            return;
        }

        if (mem[i][curr]) return;
        mem[i][curr] = true;

        backpack(i + 1, curr);

        if (weight[i] + curr < max) {
            backpack(i + 1, weight[i] + curr);
        }
    }

}
