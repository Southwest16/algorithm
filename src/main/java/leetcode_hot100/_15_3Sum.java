package leetcode_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode.com/problems/3sum/
 */
public class _15_3Sum {
	/**
	 * 前提：先要对数组排序
	 *
	 * 遍历第一个数, 第二个数在第一个数后面往右开始遍历, 第三个数从数组尾部向左遍历
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>(); //保存结果

		Arrays.sort(nums); //排序nums数组
		int n = nums.length; //数组长度

		for (int i = 0; i < n - 2; i++) {
			if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) { // 第二个条件是为了避免重复结果集
				int left = i + 1; // 左界从i的后一位元素往后遍历
				int right = n - 1; // 右界从最后一位元素往前遍历
				int sum = -nums[i]; // 其中两数之和

				while (left < right) { // 终止条件
					if (nums[left] + nums[right] == sum) {
						result.add(Arrays.asList(nums[i], nums[left], nums[right]));

						//避免重复结果
						while (left < right && nums[left] == nums[left + 1]) left++;
						while (left < right && nums[right] == nums[right - 1]) right--;

						// 收拢
						left++;
						right--;
					} else if (nums[left] + nums[right] < sum) {
						left++;
					} else {
						right--;
					}
				}
			}

		}
		return result;
	}
}
