public int findMinTrips(int[] packageweight) {
    // write your code here
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < packageweight.length; i++){
    map.put(packageweight[i], map.getOrDefault(packageweight[i], 0) + 1);
  }
  int count = 0;
  for (int key : map.keySet()){
    int value = map.get(key);
    int triplets = value / 3;
    int twice = value % 3 / 2;
    int residual = value - triplets * 3 - twice * 2;
    if (residual == 1){
      return -1;
    }
    count += triplets + twice;
  }
  return count;
}