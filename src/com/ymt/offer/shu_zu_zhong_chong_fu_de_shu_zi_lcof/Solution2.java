package com.ymt.offer.shu_zu_zhong_chong_fu_de_shu_zi_lcof;

/**
 * @author yumingtao
 * @date 2021/8/27 13:43
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0 || nums[i] > nums.length) return -1;
        }

        //空间复杂度O(n)
        int[] a = new int[n + 1];

        for(int i = 0; i < nums.length; i++){
            a[nums[i]]++;
            if(a[nums[i]] > 1) return nums[i];
        }

        return -1;
    }
}
