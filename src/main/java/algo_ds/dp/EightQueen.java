package problems.backtrack;

/**
 * N皇后
 */
public class EightQueen {
	//全局成员变量, 下标表示皇后所在行, 下标对应的值表示皇后所在列
	int[] result = new int[8];

	public void cal(int row) {
		if (row == 8) {
			print(result);
			return;
		}

		//每行都有8种放法
		for (int column = 0; column < 8; column++) {
			//判断是否满足要求
			if (isOK(row, column)) {
				//如果第row行第column列放的皇后符合要求, 就可以将此时皇后所在的行号和列号作为符合要求的结果保存到result中
				result[row] = column;

				//放置下一行
				cal(row + 1);
			}
		}
	}

	//判断(row, column)位置的皇后放置是否满足要求
	public boolean isOK(int row, int column) {
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
			if (rightUp < 8)
				if (result[i] == rightUp) return false;

			leftUp--;
			rightUp++;
		}
		return true;
	}

	public void print(int[] result) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (result[i] == j) {//第j列有皇后
					System.out.print("1  ");
				} else {
					System.out.print("0  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		EightQueen queen = new EightQueen();
		queen.cal(0);
	}
}
