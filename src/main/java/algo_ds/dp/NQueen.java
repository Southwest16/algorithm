package problems.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    //int[] result = new int[4];
    private List<List<Integer>> result = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        System.out.println(nQueen.solveNQueens(4));
    }

    public List<List<Integer>> solveNQueens(int n) {
        if (n < 1)
            return new ArrayList<>();

        dfs(n, 0, new ArrayList<>());

        return result;
    }

    public void dfs(int n, int row, ArrayList<Integer> curState) {
        if (row >= n) {
            result.add(curState);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(col - row))
                continue;

            cols.add(col);
            pie.add(row + col);
            na.add(col - row);

            curState.add(col);
            dfs(n, row+1, curState);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(col - row);
        }
    }

//    public void printResult (int n) {
//        List<String> board = new ArrayList<>();
//        for (int i = 0; i < result.size(); i++) {
//            for (int j = 0; j < result.get(i).size(); j++) {
//                board.add()
//
//            }
//        }
//    }




//    //逐行扫描
//    public void solveNQueens(int row) {
//        if (row == 4) {
//            printQueens(result);
//            return;
//        }
//
//        for (int column = 0; column < 4; ++column) {
//            if (isOk(row, column)) {
//                result[row] = column;
//                solveNQueens(row + 1);
//            }
//        }
//    }
//
//    private boolean isOk(int row, int column) {
//        int leftup = column - 1;
//        int rightup = column + 1;
//
//        for (int i = row - 1; i >= 0; i--) {
//            if (result[i] == column) return false;
//
//            if (leftup >= 0 && result[i] == leftup) return false;
//
//            if (rightup < 4 && result[i] == rightup) return false;
//
//            --leftup;
//            ++rightup;
//        }
//        return true;
//    }
//
//    private void printQueens(int[] result) {
//        for (int row = 0; row < 4; ++row) {
//            for (int column = 0; column < 4; ++column) {
//                if (result[row] == column) {
//                    System.out.print("O ");
//                } else {
//                    System.out.print("* ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
