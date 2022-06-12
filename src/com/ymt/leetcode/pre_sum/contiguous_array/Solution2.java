package com.ymt.leetcode.pre_sum.contiguous_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+map+没有使用前缀和数组
 * @author yumingtao
 * @date 2021/9/17 16:51
 */
public class Solution2 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int counter = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            /*if (nums[i] == 0) {
                nums[i] = -1;
            }

            counter += nums[i];*/
            if(nums[i] == 0){
                counter--;
            }else{
                counter++;
            }

            if (map.containsKey(counter)) {
                ans = Math.max(ans, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }

        return ans;
    }
}
