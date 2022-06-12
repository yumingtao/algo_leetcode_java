package com.ymt.leetcode.two_pointers.longest_subarray_of_1s_after_deleting_one_element;

/**
 * 思路:滑窗
 * 1.把0换成1，把1换成0，问题求解转换成"求包含1的个数<=1的最长子数组长度"
 * 2.求解完成后减1(删除一个元素)
 *
 * @author yumingtao
 * @date 2021/12/15 15:17
 */
public class Solution2 {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int oneCount = 0;
        int maxLen = 0;
        while (right < len) {
            while (right < len && oneCount <= 1) {
                if (nums[right] == 0) {
                    ++oneCount;
                }
                if (oneCount <= 1) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                ++right;
            }
            //如果right已经到达末尾
            if(right == len){
                //注意要减1
                return maxLen - 1;
            }
            //收缩left
            while (left <= right && oneCount > 1){
                if(nums[left] == 0){
                    --oneCount;
                }
                ++left;
            }
        }
        //注意要减1
        return maxLen - 1;
    }
}
