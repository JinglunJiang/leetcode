class Solution {
    public int minOperations(String s) {
        boolean flag = true;
        int count = 0;
        for (char c : s.toCharArray()){
            if (flag){
                if (c != '0'){
                    count++;
                }
            }
            else{
                if (c != '1'){
                    count++;
                }
            }
            flag = !flag;
        }
        int count2 = 0;
        boolean flag2 = false;
        for (char c : s.toCharArray()){
            if (flag2){
                if (c != '0'){
                    count2++;
                }
            }
            else{
                if (c != '1'){
                    count2++;
                }
            }
            flag2 = !flag2;
        }
        return Math.min(count, count2);
    }
}