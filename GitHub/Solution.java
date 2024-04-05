import java.util.*;

public class Solution{
  public static int solution(int U, int[] weight){
    Queue<Integer> queue = new LinkedList<>();
    int currentWeight = 0;
    int count = 0;
    for (int i = 0; i < weight.length; i++){
      if (queue.size() == 2){
        currentWeight -= queue.poll();
      }
      currentWeight += weight[i];
      if (currentWeight > U){
        count += 1;
        currentWeight -= weight[i];
      }
      else{
        queue.offer(weight[i]);
      }
    }
    return count;
  }

  public static void main(String[] args){
    int U = 9;
    int[] weight = {5, 3, 8, 1, 7, 7, 6};
    System.out.println(solution(U, weight));
  }
}