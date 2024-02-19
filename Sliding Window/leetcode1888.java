class Solution {
    public int minFlips(String s) {
        StringBuilder sb = new StringBuilder(s).append(s);

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();
        
        for (int i = 0; i < sb.length(); i++){
            if (i % 2 == 0){
                alt1.append(0);
                alt2.append(1);
            }
            else{
                alt1.append(1);
                alt2.append(0);
            }
        }

        int result = sb.length();
        int left = 0;
        int diff1 = 0;
        int diff2 = 0;

        for (int right = 0; right < sb.length(); right++){
            if (sb.charAt(right) != alt1.charAt(right)){
                diff1++;
            }
            if (sb.charAt(right) != alt2.charAt(right)){
                diff2++;
            }
            if (right - left + 1 > s.length()){
                if (sb.charAt(left) != alt1.charAt(left)){
                    diff1--;
                }
                if (sb.charAt(left) != alt2.charAt(left)){
                    diff2--;
                }
                left++;
            }
            if (right - left + 1 == s.length()){
                result = Math.min(result, Math.min(diff1, diff2));
            }
        }
        return result;
    }
}