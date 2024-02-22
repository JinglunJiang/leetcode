public int findLongestSubstringWithWildcard(String s1, String s2) {
    // write your code here
  String[] parts = s2.split("\\*", -1);
  String prefix = parts[0];
  String suffix = parts[1];

  int maxLength = 0;
  
  for (int i = 0; i <= s1.length() - prefix.length(); i++){
    if (s1.startsWith(prefix, i)){
      int suffixStart = i + prefix.length();
      for (int j = suffixStart; j <= s1.length() - suffix.length(); j++){
        if (s1.startsWith(suffix, j)){
          int currentLength = prefix.length() + (j - suffixStart) + suffix.length();
          maxLength = Math.max(maxLength, currentLength);
        }
      }
    }
  }
  return maxLength;
}