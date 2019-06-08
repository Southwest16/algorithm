package geektime_algorithm.backtrack;

public class BackPack {
    int[] weight = {10, 5, 12, 22, 50};
    int n = weight.length;
    int max = Integer.MAX_VALUE;
    int result = 0;

    public void p(int i, int curr) {
        if (curr == max || i == n) {
            if (curr > result) result = curr;
            return;
        }

        p(i+1, curr);

        if (curr + weight[i] <= max) {
            p(i+1, curr+weight[i]);
        }
    }

}
