//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//例如，121 是回文，而 123 不是。

package dayTwo.isPalindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        int end = 1;
        int start = 1;
        if(x < 0 || x == 10)
            return false;
        if(x < 10)
            return true;
        for (int i = x; i > 9; i= i / 10) {
            end *= 10;
        }

        while (start < end){
            System.out.println(x / end);
            System.out.println((x % (start * 10)) / start);
            if(x / end != (x % (start * 10)) / start)
                return false;
            start *= 10;
            x -= x / end * end;
            end /= 10;
        }
        return true;
    }
}
