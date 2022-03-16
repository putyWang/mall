/*给你一个字符串 s，找到 s 中最长的回文子串。
* 可以使用动态规划；
* */
package dayTwo.longestPalindrome;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int fast = 0;
        int last = 0;
        String result = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            fast = i + 1;
            last = i - 1;
            while (fast < s.length() && last >= 0) {
                if (s.charAt(fast) == s.charAt(last)) {
                    if (result.length() < s.substring(last, fast + 1).length())
                        result = s.substring(last, fast + 1);
                } else
                    break;
                last--;
                fast++;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            fast = i;
            last = i - 1;
            while(fast < s.length() && last >= 0){
                if (s.charAt(fast) == s.charAt(last)){
                    if(result.length() < s.substring(last,fast + 1).length())
                        result = s.substring(last,fast + 1);
                }else
                    break;
                last --;
                fast ++;
            }
        }
        return result;
    }
}
