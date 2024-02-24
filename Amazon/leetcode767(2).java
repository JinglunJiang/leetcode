class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()){
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char current = queue.poll();
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != current){
                sb.append(current);
                map.put(current, map.get(current) - 1);
                if (map.get(current) != 0){
                    queue.offer(current);
                }
            }
            else{
                if (queue.isEmpty()){
                    return "";
                }
                else{
                    char next = queue.poll();
                    sb.append(next);
                    map.put(next, map.get(next) - 1);
                    if (map.get(next) != 0){
                        queue.offer(next);
                    }
                }
                queue.offer(current);
            }
        }
        return sb.toString();
    }
}