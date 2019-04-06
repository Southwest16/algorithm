package leetcode;

/**
 * 两个矩阵相乘。只有当第一个矩阵的列数和第二个矩阵的行数相同才能相乘。
 * A(m * p) * B(p * n) => C(m * n)
 */
public class MatrixMultiply {
    /**
     * 思路
     * 第一层循环：循环第一个矩阵的每一行
     * 第二层循环：循环第二个矩阵的每一列
     * 第三层循环：循环第一个矩阵的每一行的每个元素，或者循环第二个矩阵的每一列的每个元素
     */
    public static int[][] matrixMultiply(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second[0].length];

        //第一个矩阵的行数
        for (int i = 0; i < first.length; i++) {
            //第二个矩阵的列数
            for (int j = 0; j < second[0].length; j++) {
                //第二个矩阵的行数(first[0].length等于second.length)
                for (int k = 0; k < second.length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] first = {{1, 2}, {3, 4}, {5, 6}};
        int[][] second = {{1, 3}, {0, 6}};

        System.out.println(MatrixMultiply.matrixMultiply(first, second)[0][0]);

        //System.out.println(first.length);   //矩阵行数
        //System.out.println(first[0].length);//矩阵列数
    }
}
