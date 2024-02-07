class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);

        StringBuilder result = new StringBuilder();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            result.append('-');
        }

        result.append(a / b);
        a %= b;
        
        if (a > 0){
            result.append('.');
        }

        HashMap<Long,Integer> map = new HashMap<>();

        while (!map.containsKey(a)){
            map.put(a, map.size());
            a = a * 10;
            if (a > 0){
                result.append(a / b);
            }
            a %= b;
        }

        if (a > 0){
            result.insert(result.length() - (map.size() - map.get(a)), '(');
            result.append(')');
        }
        return result.toString();
    }
}