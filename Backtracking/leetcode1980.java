class Solution {
    Set<String> set = new HashSet<>();

    public String findDifferentBinaryString(String[] nums) {
        for (String num : nums){
            set.add(num);
        }
        return backtracking(nums.length, new StringBuilder());
    }

    public String backtracking(int length, StringBuilder sb){
        if (sb.length() == length){
            String str = sb.toString();
            if (!set.contains(str)){
                return str;
            }
            return "";
        }
        sb.append('0');
        String found = backtracking(length, sb);
        if (!found.isEmpty()){
            return found;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        found = backtracking(length, sb);
        if (!found.isEmpty()){
            return found;
        }
        sb.deleteCharAt(sb.length() - 1);
        return "";
    }
}