package leetcode_hot100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并区间
 * https://leetcode.com/problems/merge-intervals/
 */
public class _56_MergeIntervals {
	private class IntervalComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
		}
	}

	public int[][] merge(int[][] intervals) {
		//以每个区间的第一个元素对所有区间排序
		Collections.sort(Arrays.asList(intervals), new IntervalComparator());

		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) { //区间不相交
				merged.add(interval);
			} else { //区间相交
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
