package leetcode.hot100;

/**
 * 旋转图像
 * https://leetcode.com/problems/rotate-image/
 */
public class _48_RotateImage {
	public void rotate(int[][] matrix) {
		//矩阵上线对称交换
		int start = 0;
		int end = matrix.length - 1;
		while (start < end) {
			int[] tmp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = tmp;
			start++;
			end--;
		}

		//矩阵的对角线元素进行交换
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
