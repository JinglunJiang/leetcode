class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < quiet.length; i++){
            list.add(new ArrayList<>());
        }

        for (int[] pair : richer){
            list.get(pair[1]).add(pair[0]);
        }

        int[] result = new int[quiet.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < result.length; i++){
            dfs(i, list, quiet, result);
        }

        return result;
    }

    public int dfs(int i, List<List<Integer>> list, int[] quiet, int[] result){
        if (result[i] != -1){
            return result[i];
        }

        result[i] = i;
        for (int candidate : list.get(i)){
            int value = dfs(candidate, list, quiet, result);
            if (quiet[value] < quiet[result[i]]){
                result[i] = value;
            }
        }
        return result[i];
    }
}