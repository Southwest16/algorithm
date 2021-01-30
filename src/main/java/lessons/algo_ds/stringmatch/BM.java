package lessons.algo_ds.stringmatch;

/**
 * BM(Boyer-Moore)算法代码实现
 */
public class BM {
	private static final int SIZE = 256;

	// a,b表示主串和模式串；n，m表示主串和模式串的长度。
	public int bm(char[] a, int n, char[] b, int m) {
		int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
		generateBC(b, m, bc); // 构建坏字符哈希表
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGS(b, m, suffix, prefix);
		int i = 0; // j表示主串与模式串匹配的第一个字符
		while (i <= n - m) {
			int j;
			for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
				if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是j
			}
			if (j < 0) {
				return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
			}
			int x = j - bc[(int)a[i+j]];
			int y = 0;
			if (j < m-1) { // 如果有好后缀的话
				y = moveByGS(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	// j表示坏字符对应的模式串中的字符下标; m表示模式串长度
	private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // 好后缀长度
		if (suffix[k] != -1) return j - suffix[k] +1;
		for (int r = j+2; r <= m-1; ++r) {
			if (prefix[m-r] == true) {
				return r;
			}
		}
		return m;
	}

	/**
	 * @param b  模式串
	 * @param m  模式串长度
	 * @param bc 散列表。假设字符串的字符集不是很大，每个字符长度是 1 字节，我们用大小为 256 的数组，来记录每个字符在模式串中出现的位置。数组的下标对应字符的 ASCII 码值，数组中存储这个字符在模式串中出现的位置。
	 */
	private void generateBC(char[] b, int m, int[] bc) {
		for (int i = 0; i < SIZE; i++)
			bc[i] = -1; // 初始化bc


		for (int i = 0; i < m; i++) {
			int ascii = (int) b[i];
			bc[ascii] = i;
		}
	}

	/**
	 * @param b      模式串
	 * @param m      模式串长度
	 * @param suffix suffix 数组的下标 k，表示后缀子串的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值
	 * @param prefix 来记录模式串的后缀子串是否能匹配模式串的前缀子串
	 */
	private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
		//初始化
		for (int i = 0; i < m; i++) {
			suffix[i] = -1;
			prefix[i] = false;
		}

		for (int i = 0; i < m - 1; i++) {
			int j = i;
			int k = 0; //公共后缀子串长度
			//与b[0, m-1]求公共后缀子串
			while (j > 0 && b[j] == b[m - 1 - k]) {
				j--;
				k++;
				suffix[k] = j + 1; //j+1表示公共后缀子串在b[0, i]中的起始下标
			}
			if (j == -1) prefix[k] = true;
		}
	}
}
