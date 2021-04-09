package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * https://leetcode.com/problems/n-queens/
 */
public class _51_NQueens {
	//入口函数
	public List<List<String>> solveNQueens(int n) {
		//全局成员变量, 下标表示皇后所在行, 下标对应的值表示皇后所在列
		int[] result = new int[n];
		List<List<String>> resultList = new ArrayList<>();
		cal(0, n, result, resultList);

		return resultList;
	}

	//递归函数
	public void cal(int row, int n, int[] result, List<List<String>> resultList) {
		if (row == n) {
			output(result, n, resultList);



			/*List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int left = result[i];
				int right = n-1-result[i];
				list.add();
			}
			resultList.add(list);*/



			return;
		}

		//每行都有8种放法
		for (int column = 0; column < n; column++) {
			//判断是否满足要求
			if (isOK(row, n, column, result)) {
				//如果第row行第column列放的皇后符合要求, 就可以将此时皇后所在的行号和列号作为符合要求的结果保存到result中
				result[row] = column;

				//放置下一行
				cal(row + 1, n, result, resultList);
			}
		}
	}

	//判断(row, column)位置的皇后放置是否满足要求
	public boolean isOK(int row, int n, int column, int[] result) {
		int leftUp = column - 1; //当前位置的左上角
		int rightUp = column + 1; //当前位置的右上角

		//从当前行的上一行开始判断当前行的皇后是否符合放置要求
		for (int i = row - 1; i >= 0; i--) {
			//当前行的皇后所在的列不能有皇后
			if (result[i] == column) return false;

			//判断左上角是否有皇后
			if (leftUp >= 0)
				if (result[i] == leftUp) return false;

			//判断右上角是否有皇后
			if (rightUp < n)
				if (result[i] == rightUp) return false;

			leftUp--;
			rightUp++;
		}
		return true;
	}

	//输出
	public void output(int[] result, int n, List<List<String>> resultList) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = 0; j < n; j++) {
				if (result[i] == j) {//第j列有皇后
					s += "Q";
				} else {
					s += ".";
				}
			}
			list.add(s);
		}
		resultList.add(list);
	}

	public static void main(String[] args) {
		_51_NQueens queen = new _51_NQueens();
		System.out.println(queen.solveNQueens(4));
	}
}
