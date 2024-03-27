class LRUCache {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int k;

    public LRUCache(int capacity) {
        k = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            int result = map.get(key);
            map.remove(key);
            map.put(key, result);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
        if (map.size() > k){
            int first = map.keySet().iterator().next();
            map.remove(first);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */