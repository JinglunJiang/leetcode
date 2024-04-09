import java.util.*;

// Input: A String which is a website link
// Output: A String which is the reversed website link according to the sperator "."

// Constraints: It is not possible for the "www.apple.com" 
// Time Complexity?

// Idea: String[] store different part of the original string, iterate backward, add the seperator back
// String.split("\\.");
// StringBuilder()
// Time complexity: O(n)
// Space complexity: O(n)

// Test case: Input: www.apple.com Return: com.apple.www

class textConversion3 {
    public static String textConverter(String inputString){
        String[] stringArray = inputString.split('\\.');
        StringBuilder sb = new StringBuilder();
        for (int i = stringArray.length - 1; i >= 0; i--){
            sb.append(stringArray[i]);
            if (i != 0){
                sb.append('.');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String input = "www.apple.com";
        r textConverter(input);
    }
}