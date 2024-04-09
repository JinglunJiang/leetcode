class LRUCache {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int max;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            makeRecent(key);
            return map.get(key);
        }
        return -1;
    }

    public void makeRecent(int key){
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
        if (map.keySet().size() > max){
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */