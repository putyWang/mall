/* 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
*  算法的时间复杂度应该为 O(log (m+n))
*/

package dayOne.findMedianSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0;
        int i1 =0;
        int i2 =0;
        double[] preResult = {0.0,0.0};
        double result = 0;
        if(l1 == 0 ){
            if(nums2.length == 0)
                return 0;
            else if(l2 % 2 != 0)
                return nums2[(l2 - 1)/2];
            else
                return ((double)nums2[(l2)/2] + (double)nums2[(l2)/2 - 1])/2;
        }else if(l2 == 0){
            if (l1 % 2 != 0)
                return nums1[(l1 - 1)/2];
            else
                return (double)(nums1[(l1)/2] + (double)nums1[(l1)/2 - 1])/2;
        }
        if((l1 + l2) % 2 != 0){
            while(i <= (l1 + l2 - 1)/ 2){
                if(i1 < l1 && i2 < l2){
                    if(nums1[i1] < nums2[i2]) {
                        result = nums1[i1];
                        i1++;
                    }
                    else{
                        result = nums2[i2];
                        i2++;
                    }
                }else if(i1 >= l1){
                    result = nums2[i2];
                i2++;
                }else{
                    result = nums1[i1];
                    i1++;
                }
                i ++;
            }
        }else {
            while(i <= (l1 + l2)/ 2){
                if(i1 < l1 && i2 < l2){
                    if( nums1[i1] < nums2[i2]) {
                        preResult[0] = preResult[1];
                        preResult[1] = nums1[i1];
                        i1++;
                    }
                    else{
                        preResult[0] = preResult[1];
                        preResult[1] = nums2[i2];
                        i2++;
                    }

                }else if(i1 >= l1){
                    preResult[0] = preResult[1];
                    preResult[1] = nums2[i2];
                    i2++;
                }else{
                    preResult[0] = preResult[1];
                    preResult[1] = nums1[i1];
                    i1++;
                }
                i ++;
            }
            result = (preResult[0] + preResult[1]) / 2;
        }
        return result;
    }
}
