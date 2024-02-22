import java.util.*;

public class RewardsSystem {

  public static int maxRewards(int[] rewards){
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int reward : rewards){
      queue.offer(reward);
    }

    int result = 0;
    int count = 0;

    while (!queue.isEmpty()){
      int current = queue.poll() - count;
      if (current > 0){
        result += current;
        count++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] reward = {5, 2, 2, 3, 1};
    int n = 5;
    System.out.println(maxRewards(reward));  // Output should be the maximum possible rewards
  }
}