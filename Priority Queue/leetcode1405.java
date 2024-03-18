class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> map = new HashMap<>();
        if (a != 0) map.put('a', a);
        if (b != 0) map.put('b', b);
        if (c != 0) map.put('c', c);
        PriorityQueue<Character> queue = new PriorityQueue<>((e, f) -> map.get(f) - map.get(e));
        for (Character key : map.keySet()){
            queue.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != queue.peek()){
                char current = queue.poll();
                if (map.get(current) >= 2){
                    sb.append(current);
                    sb.append(current);
                    map.put(current, map.get(current) - 2);
                    if (map.get(current) > 0){
                        queue.offer(current);
                    }
                }
                else{
                    sb.append(current);
                    map.remove(current);
                }
            }
            else{
                char previous = queue.poll();
                if (queue.isEmpty()){
                    return sb.toString();
                }
                char current = queue.poll();
                sb.append(current);
                map.put(current, map.get(current) - 1);
                if (map.get(current) != 0){
                    queue.offer(current);
                }
                else{
                    map.remove(current);
                }
                queue.offer(previous);
            }
        }
        return sb.toString();
    }
}