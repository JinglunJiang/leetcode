class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gindex = 0;
        int sindex = 0;
        int count = 0;
        while (gindex < g.length && sindex < s.length){
            if (g[gindex] <= s[sindex]){
                gindex++;
                sindex++;
                count++;
            }
            else{
                sindex++;
            }
        }
        return count;
    }
}