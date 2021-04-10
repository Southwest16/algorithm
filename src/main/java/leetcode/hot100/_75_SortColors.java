package leetcode.hot100;

/**
 * 颜色分类
 * https://leetcode.com/problems/sort-colors/
 */
public class _75_SortColors {
	public static void main(String[] args) {
		int[] nums = {2, 0, 2, 1, 1, 0};
		sortColors(nums);
		System.out.println();
	}

	public static void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0 && i != left) {
				int tmp = nums[i];
				nums[i] = nums[left];
				nums[left] = tmp;
				i--;
				left++;
			} else if (nums[i] == 2 && i != right) {
				int tmp = nums[i];
				nums[i] = nums[right];
				nums[right] = tmp;
				i--;
				right--;
			}
		}
	}

	public static void sortColors2(int[] nums) {
		int n0 = -1;
		int n1 = -1;
		int n2 = -1;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				nums[++n2] = 2;
				nums[++n1] = 1;
				nums[++n0] = 0;
			} else if (nums[i] == 1) {
				nums[++n2] = 2;
				nums[++n1] = 1;
			} else {
				nums[++n2] = 2;
			}
		}
	}
}
