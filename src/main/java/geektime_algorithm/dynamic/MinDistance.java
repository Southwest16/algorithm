package geektime_algorithm.dynamic;

/**
 * 求矩阵从左上角到右下角的最短距离
 */
public class MinDistance {
    private int[][] a = {
            {1, 3, 5, 9},
            {2, 1, 3, 4},
            {5, 2, 6, 7},
            {6, 8, 4, 3}};
    private int[][] memory = new int[4][4];

    public static void main(String[] args) {
        MinDistance ms = new MinDistance();

        //System.out.println(ms.minDisDP(4));
        System.out.println(ms.minDisDP2(3, 3));
    }


    public int minDisDP2(int i, int j) {
        if (i == 0 && j == 0) return a[0][0];

        if (memory[i][j] > 0) return memory[i][j];

        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDisDP2(i, j-1);
        }

        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDisDP2(i-1, j);
        }

        int currMinDis = a[i][j] + Math.min(minLeft, minUp);
        memory[i][j] = currMinDis;

        return currMinDis;
    }

    /**
     * 状态转移表法
     * @param a
     * @param n
     * @return
     */
    public int minDisDP(int n) {
        //状态表, 记录从左上角到当前坐标的最短距离
        int[][] state = new int[n][n];

        //填充状态表的第一行
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[0][i];
            state[0][i] = sum;
        }

        //填充状态表的第一列
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += a[j][0];
            state[j][0] = sum;
        }

        //逐行填充状态表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //数组的当前坐标(i,j)的值加上它左边和上边坐标中的较小值
                state[i][j] = a[i][j] + Math.min(state[i-1][j], state[i][j-1]);
            }
        }

        //返回状态表的最后一个坐标的值就是所求的最短距离
        return state[n-1][n-1];
    }
}
