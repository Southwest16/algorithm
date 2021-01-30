package leetcode.hot100;

/**
 * 不同的二叉搜索树
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class _96_UniqueBinarySearchTrees {
	/**
	 * 动态规划
	 *
	 * 参考：https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
	 * G(n): the number of unique BST for a sequence of length n.
	 * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
	 * <p>
	 * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
	 * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
	 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
	 *
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; i++) { // 以i为子树的节点数
			for (int j = 1; j <= i; j++) {// 以j为根节点
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}
}
