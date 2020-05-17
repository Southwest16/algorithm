package algo_ds.dp;

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
}
