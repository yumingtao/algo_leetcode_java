package com.ymt.leetcode.pre_sum.maximum_number_of_non_overlapping_subarrays_with_sum_equals_target;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 1.因为不重叠，所以从左到右，索引最小的解一定会被选择
 * 2.j<=i,区间和pSum[i]-pSum[j]=target -> pSum[j]=pSum[i]-target，看在i之前是否出现过pSum[i]-target
 *
 * @author yumingtao
 * @date 2021/10/26 10:54
 */
public class Solution1 {
    public int maxNonOverlapping(int[] nums, int target) {
        int pSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            pSum = pSum + nums[i];
            int key = pSum - target;
            if (map.containsKey(key)) {
                ans += map.get(key);
                map.clear();
            }
            map.put(pSum, 1);
        }

        return ans;
    }
}


/**
 * 10
 * -2,6,6, 3, 5, 4,  1,  2,  8
 * 0 -2 4 10 13 18 22  23  25  33
 * 寻找等于target的区间和的个数
 * <p>
 * pSum[i]-pSum[j]=target
 * pSum[j]=pSum[i]-target
 * [1,1,1,1,1]
 * 2
 * 0 1 2 3 4 5
 */