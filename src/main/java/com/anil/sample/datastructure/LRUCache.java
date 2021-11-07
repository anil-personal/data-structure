package com.anil.sample.datastructure;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * The LRU cache.
 * Given the size of the cache, the cache should evict the LRU item once cache is full.
 */
public class LRUCache {

    private final int size;

    private final LinkedHashMap<String, String> cache;

    /**
     * The LRU Cache
     *
     * @param size the size
     */
    public LRUCache(int size) {
        this.size = size;
        cache = new LinkedHashMap<>();
    }

    public void putItem(String key, String value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() >= this.size) {
            String lruKey = cache.keySet().iterator().next();
            cache.remove(lruKey);
        }
        cache.put(key, value);
    }

    public String getItem(String key) {
        return markItemAsUsedRecently(key);
    }

    private String markItemAsUsedRecently(String key) {
        if (cache.containsKey(key)) {
            String value = cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return null;
    }

    private void printItems() {
        System.out.println("Cache content : " + cache);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.putItem("1", "1");
        lruCache.putItem("2", "2");
        lruCache.putItem("3", "3");
        lruCache.printItems();
        System.out.println("Accessing first time" + lruCache.getItem("1"));
        lruCache.printItems();
        lruCache.putItem("4", "4");
        lruCache.printItems();
        System.out.println("Accessing first time" + lruCache.getItem("1"));
        lruCache.printItems();
    }

}
