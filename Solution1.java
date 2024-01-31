import java.util.*;

public class Solution1 {
    public static List<Integer> segmentMax(List<Integer> cat, List<Integer> cnt, List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int n = cat.size();

        for (int i = 0; i < left.size(); i++) {
            int leftIdx = left.get(i) - 1;
            int rightIdx = right.get(i) - 1;

            Map<Integer, Integer> categoryCount = new HashMap<>();

            // Find the maximum count for each category in the range
            for (int j = leftIdx; j <= rightIdx; j++) {
                int category = cat.get(j);
                int count = cnt.get(j);
                categoryCount.put(category, Math.max(categoryCount.getOrDefault(category, 0), count));
            }

            int totalCount = categoryCount.values().stream().mapToInt(Integer::intValue).sum();
            result.add(totalCount);

            // Set the counts in the range to 0
            for (int j = leftIdx; j <= rightIdx; j++) {
                cnt.set(j, 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> cat = Arrays.asList(1, 2, 1, 3, 5, 4, 3);
        List<Integer> cnt = Arrays.asList(1, 3, 2, 5, 3, 2, 1);
        List<Integer> l = Arrays.asList(1, 1);
        List<Integer> r = Arrays.asList(3, 5);
        List<Integer> result = segmentMax(cat, cnt, l, r);

        System.out.println(result);
    }
}