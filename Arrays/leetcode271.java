class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str);
            sb.append("~");
        }
        String result = new String(sb.toString());
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '~'){
                result.add(str.substring(start, i));
                start = i + 1;
            }
        }
        return result;
    }
}
