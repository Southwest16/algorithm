package leetcode.hot100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_FindFirstLastInSortedArray {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(searchRange(nums, target));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];

		//findFirst和findLast的唯一区别是目标值放在左半边还是右半边
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);

		return result;
	}

	private static int findFirst(int[] nums, int target){
		int idx = -1;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(nums[mid] >= target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
			if(nums[mid] == target) idx = mid;
		}
		return idx;
	}

	private static int findLast(int[] nums, int target){
		int idx = -1;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(nums[mid] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
			if(nums[mid] == target) idx = mid;
		}
		return idx;
	}
}
