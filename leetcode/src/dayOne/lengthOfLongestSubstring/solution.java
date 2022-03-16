/*
* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */

package dayOne.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class solution {
    public int lengthOfLongestSubstring(String s) {

        Map map = new HashMap<Character, Integer>();
        int fast = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i ++){
            if(i != 0)
                map.remove(s.charAt(i-1));
            while (fast != s.length() && !map.containsKey(s.charAt(fast))){
                map.put(s.charAt(fast),fast);
                fast++;
            }
            if (count < fast - i)
                count = fast - i;
        }
        return count;
    }
}
