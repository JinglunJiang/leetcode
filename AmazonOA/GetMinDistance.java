public long getMinDistance(int[] center, int[] destination) {
    // write your code here
  Arrays.sort(center);
  Arrays.sort(destination);
  long result = 0;
  for (int i = 0; i < center.length; i++){
    result += Math.abs((long)center[i] - (long)destination[i]);
  }
  return result;
}