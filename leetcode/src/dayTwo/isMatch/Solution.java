

package dayTwo.isMatch;


public class Solution {
    public boolean isMatch(String s, String p) {

        //对s循环次数进行计数
        int count = 0;
        int pPoint = 0;
        if(s.length() == 0 || p.contains(".*"))
            return true;
        else if (p.length() == 0)
            return false;

        //p中不包含*
        if(!p.contains("*")){
            //p中不包含* s长度大于p 不匹配
            if(s.length() > p.length())
                return false;
            //s循环结束，匹配
            for (int i = 0; i < p.length(); i++) {
                //若s可以第一个字符与p中字符匹配且s长度小于p剩余长度
                if(p.charAt(i) == s.charAt(0) && s.length() <= p.length() - i){
                    for (int j = 0; j < s.length(); j++) {
                        if(s.charAt(j) != p.charAt(i + j) && p.charAt(i + j) != '.')
                            return false;
                    }
                    return true;
                }else if (s.length() > p.length() - i)
                    return false;
            }
        }
        //p中包含*
        for (int i = 0; i < p.length(); i++) {
            //s中起始元素能匹配上p中元素，开始下一步全面匹配
            if (p.charAt(i) == s.charAt(0) || p.charAt(0) == '.') {
                count = 0;
                pPoint = i;
                for (int j = 0; j < s.length(); j++) {
                    if (pPoint >= p.length())
                        return false;
                    count ++;
                    //元素相同或者p中元素为.，直接跳下一步
                    if (s.charAt(j) == p.charAt(pPoint) || p.charAt(pPoint) == '.') {
                        pPoint++;
                        continue;
                        //p 中元素为*
                    } else if (p.charAt(pPoint) == '*') {
                        //若等于*前元素，则表明*可替代本元素,直接匹配下一个
                        if (s.charAt(j) == p.charAt(pPoint - 1))
                            continue;
                            //若不等于*前元素，则表明*不替代本元素,直接匹配p中下一元素，匹配上则跳过下一元素继续匹配；
                        else if (s.charAt(j) == p.charAt(pPoint + 1) || p.charAt(pPoint + 1) == '.') {
                            pPoint += 2;
                            continue;
                        } else
                            return false;
                    } else
                        break;
                }
                //循环结束，若count与s长度相同，则表示匹配成功
                if (count == s.length())
                    return true;
            }
        }
        return false;
    }
}
