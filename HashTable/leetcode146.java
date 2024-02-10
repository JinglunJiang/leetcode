class LRUCache {

    HashMap<Integer, Integer> map = new LinkedHashMap<>();
    int max = 0;

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
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
        if (map.size() > max){
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
    }

    public void makeRecent(int key){
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */