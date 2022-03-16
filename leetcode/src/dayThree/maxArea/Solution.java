//给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//返回容器可以储存的最大水量。


package dayThree.maxArea;

public class Solution {

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int result = 0;

        if(height.length == 0)
            return 0;

        while (start < end){
            if(height[start] > height[end]){
                result = result > height[end] * (end - start) ? result : height[end] * (end - start);
                end --;
            }

            else{
                result = result > height[start] * (end - start) ? result : height[start] * (end - start) ;
                start ++;
            }
        }


//        for (int i = 0; i < height.length; i++) {
//            for (int j = height.length - 1; j > i ; j--) {
//                if(height[i] > height[j])
//                    result = result > height[j] * (j - i) ? result : height[j] * (j - i);
//                else
//                    result = result > height[i] * (j - i) ? result : height[i] * (j - i);
//            }
//        }
        return result;
    }
}
