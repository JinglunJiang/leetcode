class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (char c : map.keySet()){
            queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!map.isEmpty()){
            if (sb.length() == 0){
                char c = queue.poll();
                sb.append(c);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0){
                    map.remove(c);
                }
                else{
                    queue.offer(c);
                }
            }
            else if (sb.charAt(sb.length() - 1) == queue.peek()){
                char previous = queue.poll();
                if (queue.isEmpty()){
                    return "";
                }
                char current = queue.poll();
                sb.append(current);
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0){
                    map.remove(current);
                }
                else{
                    queue.offer(current);
                }
                queue.offer(previous);
            }
            else{
                char current = queue.poll();
                sb.append(current);
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0){
                    map.remove(current);
                }
                else{
                    queue.offer(current);
                }
            }
        }
        return sb.toString();
    }
}