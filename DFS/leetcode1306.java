class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> set = new HashSet<>();
        return reach(set, arr, start);
    }

    private boolean reach(HashSet<Integer> set, int[] arr, int start){
        if (arr[start] == 0){
            return true;
        }
        set.add(start);
        boolean one = false;
        boolean two = false;
        if (start + arr[start] < arr.length && !set.contains(start + arr[start])){
            one = reach(set, arr, start + arr[start]);
        }
        if (start - arr[start] >= 0 && !set.contains(start - arr[start])){
            two = reach(set, arr, start - arr[start]);
        }
        return one || two;
    }
}