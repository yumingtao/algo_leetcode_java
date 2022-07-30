package com.ymt.offer.shu_zu_zhong_chong_fu_de_shu_zi_lcof;

import java.util.Arrays;

/**
 * @author yumingtao
 * @date 2021/8/27 13:43
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        //O(nlogn)
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0 || nums[i] > nums.length) return -1;
            if(i > 0 && nums[i - 1] == nums[i]) return nums[i];
        }

        return -1;
    }
}
