package com.ymt.leetcode.array.maximum_number_of_non_overlapping_subarrays_with_sum_equals_target;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：官方题解参考
 * 1.因为不重叠，所以从左到右，索引最小的解一定会被选择
 * 2.j<=i,区间和pSum[i]-pSum[j]=target -> pSum[j]=pSum[i]-target，看在i之前是否出现过pSum[i]-target
 *
 * @author yumingtao
 * @date 2021/10/26 15:06
 */
public class Solution3 {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        Set<Integer> set;
        int ans = 0;
        while (i < n) {
            set = new HashSet<>();
            set.add(0);
            int pSum = 0;
            while (i < n) {
                pSum += nums[i];
                if (set.contains(pSum - target)) {
                    ans++;
                    break;
                } else {
                    set.add(pSum);
                    //i从i+1开始继续遍历
                    i++;
                }
            }
            //i从i+1开始继续遍历
            i++;
        }

        return ans;
    }
}
