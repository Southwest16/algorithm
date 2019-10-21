package problems;

/**
 * 被围绕的区域
 * 思路：先将矩阵边上及其相邻元素是"O"的替换为某个字符(例如"#"),
 * 之后再替换回来, 其余的元素全部赋值为"X"
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] c = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions regions = new SurroundedRegions();
        regions.solve(c);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++)
                System.out.print(c[i][j] + " ");
            System.out.println();
        }
    }

    public void solve(char[][] board){
        //判断数组是否为空
        if (board.length == 0)
            return;

        int rowSize = board.length;//数组行数
        int colSize = board[0].length;//数组列数

        //遍历二维数组第一列和最后一列
        for (int row = 0; row < rowSize; row++) {
            check(board, row, 0);
            check(board, row, colSize - 1);
        }

        //遍历二维数组第一行和最后一行(为了避免重复遍历，从第一行的第二个元素到倒数第二个元素)
        for (int col = 1; col < colSize - 1; ++col) {
            check(board, 0, col);
            check(board, rowSize - 1, col);
        }

        //将"#"替换回"O"
        for (int row = 0; row < rowSize; ++row)
            for (int col = 0; col < colSize; ++col)
                board[row][col] = board[row][col] == '#' ? 'O' : 'X';
    }

    public void check(char[][] board, int row, int col){
        if (board[row][col] != 'O' || row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;

        //将矩阵边上及其相邻的是O的元素替换为"#"
        board[row][col] = '#';

        check(board, row, col - 1);
        check(board, row, col + 1);
        check(board, row + 1, col);
        check(board, row - 1, col);
    }
    
}
