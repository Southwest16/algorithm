package leetcode_hot100;

/**
 * 盛最多水的容器
 * https://leetcode.com/problems/container-with-most-water/
 */
public class _11_ContainerWithMostWater {
	public static int maxAra(int[] height) {
		int maxArea = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - 1));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxArea;
	}
}
