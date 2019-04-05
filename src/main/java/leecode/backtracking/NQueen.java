package leecode.backtracking;

public class NQueen {
    int[] result = new int[4];

    //逐行扫描
    public void solveNQueens(int row) {
        if (row == 4) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 4; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                solveNQueens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;

            if (leftup >= 0 && result[i] == leftup) return false;

            if (rightup < 4 && result[i] == rightup) return false;

            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { 
        for (int row = 0; row < 4; ++row) {
            for (int column = 0; column < 4; ++column) {
                if (result[row] == column) {
                    System.out.print("O ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(0);
    }

}
