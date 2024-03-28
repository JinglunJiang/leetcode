class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] nums, boolean[] visited, ArrayList<Integer> list){
        if (nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}