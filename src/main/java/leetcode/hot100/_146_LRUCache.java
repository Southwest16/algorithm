package leetcode.hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制
 * https://leetcode.com/problems/lru-cache/
 */
public class _146_LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private final int CAPACITY;

	public _146_LRUCache(int capacity) {
		this.CAPACITY = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > CAPACITY;
			}
		};
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		map.put(key, value);
	}
}
