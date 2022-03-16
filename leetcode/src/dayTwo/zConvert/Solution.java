//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
//比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

package dayTwo.zConvert;

public class Solution {

    public String convert(String s, int numRows) {
        String[] sBs = new String[numRows];
        String result = "";

        if(s.length() <= numRows || numRows == 1)
            return s;

        for (int i = 0; i < numRows; i++) {
            sBs[i] = String.valueOf(s.charAt(i));
        }
        for (int i = numRows; i < s.length(); i++) {
            if(i % (numRows * 2 - 2) < numRows)
                sBs[i % (numRows * 2 - 2)] = sBs[i % (numRows * 2 - 2)] + s.charAt(i);
            else
                sBs[(int)(numRows * 2 - (i % (numRows * 2 - 2)) - 2)]  = sBs[numRows * 2 - i % (numRows * 2 - 2) - 2] + s.charAt(i);
        }
        for (String sB: sBs) {
            result = result + sB;
        }
        return result;
    }
}
