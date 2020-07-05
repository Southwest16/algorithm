package leetcode_hot100;

/**
 * 搜索旋转排序数组
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class _33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 7;
		search(nums, target);
	}

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;

		//找到数组中小元素的下标
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		int rot = left;
		left = 0;
		right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int realmid = (mid + rot) % n;
			if (nums[realmid] == target) {
				return realmid;
			} else if (nums[realmid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
