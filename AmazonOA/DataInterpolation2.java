import java.util.*;

public class DataInterpolation2 {

    public static String interpolateData(String data) {
      int[] dictionary = new int[26];
      for (char c : data.toCharArray()){
        if (c != '?'){
          dictionary[c - 'a']++;
        }
      }
      StringBuilder sb = new StringBuilder();
      for (char c : data.toCharArray()){
        if (c != '?'){
          sb.append(c);
        }
        else{
          sb.append(getMin(dictionary));
        }
      }
      return sb.toString();
    }

    public static Character getMin(int[] dictionary){
      char result = 'a';
      int count = Integer.MAX_VALUE;
      for (char i = 'a'; i <= 'z'; i++){
        if (dictionary[i - 'a'] < count){
          result = i;
          count = dictionary[i - 'a'];
          dictionary[i - 'a']++;
        }
      }
      return result;
    }

    public static void main(String[] args) {
        // Test case 1: An empty string
        System.out.println(interpolateData(""));

        // Test case 2: A string with no '?' characters
        System.out.println(interpolateData("abcde"));

        // Test case 3: A string with a single '?' character
        System.out.println(interpolateData("?bcde"));

        // Test case 4: A string with multiple '?' characters in different positions
        System.out.println(interpolateData("a?c?e"));

        // Test case 5: A string with '?' characters at the beginning, middle, and end
        System.out.println(interpolateData("??abc??"));

        // Test case 6: A string where the optimal replacement for '?' is not always the same character
        System.out.println(interpolateData("a?c?e?f?h?"));

        // Test case 7: A string with all '?' characters
        System.out.println(interpolateData("?aaa????"));
    }
}