package com.ymt.leetcode.map_set.single_number;

/**
 * @Description 使用位运算
 * @author yumingtao
 * @date 2022-02-26 17:23
 */
public class Solution3 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
