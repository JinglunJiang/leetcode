class Solution {
    List<String> result = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets){
            if (!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        backtracking("JFK");
        Collections.reverse(result);
        return result;
    }

    private void backtracking(String airport){
        PriorityQueue<String> queue = map.get(airport);
        while (queue != null && !queue.isEmpty()){
            backtracking(queue.poll());
        }
        result.add(airport);
    }
}