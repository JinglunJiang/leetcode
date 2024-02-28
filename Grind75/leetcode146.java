class LRUCache {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int max;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            helper(key);
            return map.get(key);
        }
        return -1;
    }

    public void helper(int key){
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
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
}