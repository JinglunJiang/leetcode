class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty){
            if (ty > tx){
                ty %= tx;
            }
            else{
                tx %= ty;
            }
        }
        if (sx == tx && ty >= sy && (ty - sy) % sx == 0){
            return true;
        }
        return (sy == ty && tx >= sx && (tx - sx) % sy == 0);
    }
}