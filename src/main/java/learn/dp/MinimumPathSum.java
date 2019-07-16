package learn.dp;

/**
 * 最短路径
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    private int[][] array = {
            {1,3,5,9},
            {2,1,3,4},
            {5,2,6,7},
            {6,8,4,3}};
    private int n = 4;
    private int minPath = Integer.MAX_VALUE; //结果, 也就是最小路径

    /** 回溯算法 */
    public void back(int down, int right, int path) {
        //达到终点(右下角)的前一个位置(终点的上面或者左边), 程序结束
        if (down == n && right == n) {
            if (minPath > path) minPath = path;
            return;
        }

        //往下走, 更新down=down+1
        if (down < n)
            back(down+1, right, path+array[down][right]);

        //往右走, 更新right=right+1
        if (right < n)
            back(down, right+1, path+array[down][right]);
    }

    /**
     *  动态规划(状态转移表法), 从左上角到右下角
     *  参考https://time.geekbang.org/column/article/75702
     */
    public int dp() {
        int[][] state = new int[n][n];
        int sum = 0;
        for (int col = 0; col < n; col++) {
            sum += array[0][col];
            state[0][col] = sum;
        }

        sum = 0;

        for (int row = 0; row < n; row++) {
            sum += array[row][0];
            state[row][0] = sum;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                state[row][col] =
                        array[row][col] + Math.min(state[row-1][col], state[row][col-1]);
            }
        }
        return state[n-1][n-1];
    }

    /**
     * 递归。从右下角倒推到左上角
     */
    private int[][] mem = new int[4][4]; //避免重复计算
    public int rec(int i, int j) {
        //到达左上角
        if (i == 0 && j == 0) return array[0][0];
        //避免重复计算
        if (mem[i][j] > 0) return mem[i][j];

        //当前位置的左边元素
        int minLeft = Integer.MAX_VALUE;
        if (j-1 >= 0) {
            minLeft = rec(i, j-1);
        }

        //当前位置的上面元素
        int minUp = Integer.MAX_VALUE;
        if (i-1 >= 0) {
            minUp = rec(i-1, j);
        }

        //当前位置的最小路径
        int currMin = array[i][j] + Math.min(minLeft, minUp);
        //计算过保存起来, 避免重复计算
        mem[i][j] = currMin;
        return currMin;
    }

    public static void main(String[] args) {
        MinimumPathSum min = new MinimumPathSum();
        //min.back(0, 0, 0);
        //System.out.println(min.minPath);

        //System.out.println(min.dp());

        System.out.println(min.rec(3, 3));
    }
}
