class Solution {
    public int compress(char[] chars) {
        int current = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++){
            count++;
            if (i + 1 == chars.length || chars[i + 1] != chars[i]){
                chars[current] = chars[i];
                current++;
                if (count != 1){
                    for (char c : Integer.toString(count).toCharArray()){
                        chars[current] = c;
                        current++;
                    }
                }
                count = 0;
            }
        }
        return current;
    }
}