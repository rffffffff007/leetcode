public class Solution {
  public boolean isValidPalindrome(char[] cs, int start, int end) {
    while (start < end) {
      if (cs[start++] != cs[end--]) return false;
    }
    return true;
  }

  public String shortestPalindrome(String s) {
    char[] cs = s.toCharArray();
    int len = cs.length;
    int end = len - 1;
    for (; end >= 0; --end) {
      if (isValidPalindrome(cs, 0, end))
         break;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(cs, end + 1, len - 1 - end);
    sb.reverse();
    sb.append(cs, 0, end + 1);
    sb.append(cs, end + 1, len - 1 - end);
    return sb.toString();
  }
}
