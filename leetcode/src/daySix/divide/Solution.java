//给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//返回被除数dividend除以除数divisor得到的商。
//整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

package daySix.divide;

public class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        if(dividend == -2147483648){
            if(divisor == -1)
                return 2147483647;
            else if(divisor == 1)
                return -2147483648;
            else if(divisor == -2147483648)
                return 1;
        }
        if(divisor == 1)
            return dividend;
        else if(divisor == -1)
            return dividend * -1;
        if(dividend == 0)
            return 0;
        if(divisor == -2147483648)
            return 0;
        if(divisor > 0 && dividend < 0){
            while(divisor * -1 >= dividend){
                count -= 1;
                dividend += divisor;
            }
        }else if(divisor < 0 && dividend > 0) {
            while(divisor * -1 <= dividend){
                count -= 1;
                dividend += divisor;
            }
        }else if(divisor < 0 && dividend < 0){
            while(divisor >= dividend){
                count += 1;
                dividend -= divisor;
            }
        }else {
            while(divisor <= dividend){
                count += 1;
                dividend -= divisor;
            }
        }
        return count;
    }
}
