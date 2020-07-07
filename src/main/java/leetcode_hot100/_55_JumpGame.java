package leetcode_hot100;

/**
 * 跳跃游戏
 * https://leetcode.com/problems/jump-game/
 */
public class _55_JumpGame {
	//贪心算法
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int right = 0;

		for (int i = 0; i < n; i++) {
			if (i <= right) {
				//(i + nums[i])为当前位置下所能跳到的最远位置(right)
				//如果最远位置(right)大于等于最后一个元素的位置, 那就说明一定可以跳到最后一个元素
				right = Math.max(right, i + nums[i]);
				if (right >= n - 1)
					return true;
			}
		}
		return false;
	}
}
