class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> start = new HashSet<>();
        HashSet<String> destination = new HashSet<>();
        for (List<String> path : paths){
            start.add(path.get(0));
            destination.add(path.get(1));
        }
        for (String dests : destination){
            if (!start.contains(dests)){
                return dests;
            }
        }
        return null;
    }
}