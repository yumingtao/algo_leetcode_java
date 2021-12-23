package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路：官方题解递推优化
 *
 * @author yumingtao
 * @date 2021/12/23 16:13
 */
public class Solution5 {
    public int longestSubarray(int[] nums) {
        //p0[i]表示以i结尾的全是1的最长子数组长度，有
        //i位置是0，p[i]=0
        //i位置是1，p[i]=p[i-1]+1

        //p1[i]表示以i结尾，删除掉一个0，全是1的最长子数组的长度
        //i的位置是0,p1[i]=p0[i-1]
        //i的位置是1,p1[i]=p1[i-1]+1
        int maxLen = 0;
        int p0 = 0;
        int p1 = 0;
        for (int num : nums) {
            if (num == 0) {
                p1 = p0;
                p0 = 0;
            } else {
                ++p1;
                ++p0;
            }
            maxLen = Math.max(maxLen, p1);
        }
        if(maxLen == nums.length){
            --maxLen;
        }
        return maxLen;
    }
}
