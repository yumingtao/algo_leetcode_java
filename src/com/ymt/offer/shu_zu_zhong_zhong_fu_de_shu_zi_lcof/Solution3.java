package com.ymt.offer.shu_zu_zhong_zhong_fu_de_shu_zi_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yumingtao
 * @date 2021/8/27 13:43
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n =  nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        int count;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0 || nums[i] > n) return -1;
            count = map.getOrDefault(nums[i], 0);
            if(count >= 1) return nums[i];
            map.put(nums[i], count + 1);
        }
        return -1;
    }
}
