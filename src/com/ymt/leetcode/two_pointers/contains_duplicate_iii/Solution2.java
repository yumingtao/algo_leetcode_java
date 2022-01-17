package com.ymt.leetcode.two_pointers.contains_duplicate_iii;

import java.util.TreeSet;

/**
 * 思路：
 *
 * @author yumingtao
 * @date 2022/1/17 09:56
 */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (treeSet.size() <= k) {
                //包含重复元素，直接返回true
                if (treeSet.contains((long) nums[i])) {
                    return true;
                }
                //找到treeSet中最小的数x，只要nums[i]-t<=x<=nums[i]+t即可
                Long ceiling = treeSet.ceiling((long)nums[i] - t);
                if ( ceiling != null && ceiling <= (long)nums[i] + t) {
                    return true;
                }
            } else {
                treeSet.remove((long)nums[i - k]);
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }
}
