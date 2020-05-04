package algo_ds.binarysearch;

public class Heap {
	private int[] a; //存储堆的数组
	private int n; //数组长度
	private int count; //堆中元素个数

	public Heap(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	//移除堆顶元素
	public void remove() {
		//删除时要判断堆是否为空
		if (count == 0) return;

		//把堆中最后一个元素赋值给堆顶, 然后再对整个堆进行堆化
		a[1] = a[count];
		count--;

		//堆化(自上而下)
		int i = 1;
		while (true) {
			int maxPosition = i;

			//左子节点小于a[i]
			if (i * 2 < n && a[i] < a[i * 2])
				maxPosition = i * 2;

			//此处, 要判断左子节点和右子节点中的较大者, 较大者才能作为根节点
			if (i * 2 + 1 < n && a[maxPosition] < a[i * 2 + 1])
				maxPosition = i * 2 + 1;

			//a[i]比其左右子节点都大, 这种情况下, 就无须再进行比较了
			if (maxPosition == i) break;

			//交换
			int tmp = 0;
			tmp = a[i];
			a[i] = a[maxPosition];
			a[maxPosition] = tmp;

			i = maxPosition;
		}
	}

	//向堆中插入一个元素
	public void insert(int data) {
		//插入时要判断堆是否已满
		if (count > n) return;

		a[count] = data;
		count++;

		int i = count;
		//不断比较, 并交换
		while (i / 2 != 0 && a[i] > a[i / 2]) {
			int tmp = 0;
			tmp = a[i];
			a[i] = a[i / 2];
			a[i / 2] = tmp;
			i = i / 2;
		}
	}
}
