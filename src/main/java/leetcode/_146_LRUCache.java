package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * 方法一: 双链表
 * 方法二: LinkedHashMap
 */

//方法二: LinkedHashMap
public class _146_LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private final int CAPACITY;

	public _146_LRUCache(int capacity) {
		this.CAPACITY = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			//Returns true if this map should remove its eldest entry.
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > CAPACITY;
			}
		};
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

	public static void main(String[] args) {
		_146_LRUCache cache = new _146_LRUCache(2);

		cache.set(1, 10);
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " +
				cache.get(1)); // returns 10

		cache.set(3, 30);

		System.out.println("Value for the key: 2 is " +
				cache.get(2)); // returns -1 (not found)

		cache.set(4, 40);
		System.out.println("Value for the key: 1 is " +
				cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " +
				cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " +
				cache.get(4)); // return 40

	}

}


//方法一: 双链表
/*public class _146_LRUCache {
	private HashMap<Integer, Node> map;
	private int capacity, count;
	private Node head, tail;

	public _146_LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	// This method works in O(1) 
	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);

			return result;
		}
		return -1;
	}

	// This method works in O(1) 
	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capacity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

	public static void main(String[] args) {
		_146_LRUCache cache = new _146_LRUCache(2);
		cache.set(1, 10);
		cache.set(2, 20);
		cache.set(3, 30);
		cache.set(4, 40);
	}
}

class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}*/
