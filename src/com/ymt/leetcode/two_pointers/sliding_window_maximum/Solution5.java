package com.ymt.leetcode.two_pointers.sliding_window_maximum;

import java.util.TreeMap;

/**
 * @Description Solution2优化
 * @author yumingtao
 * @date 2022-01-15 16:53
 */
public class Solution5 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //TreeMap默认是按key升序，需要提供比较器,key:nums[i],value:nums[i]的计数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.intValue() - o1.intValue());
        //先初始k大小的滑动窗口
        for (int i = 0; i < k; ++i) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        int len = nums.length;
        //结果数组的长度是len-k+1
        int[] ans = new int[len - k + 1];
        //向右滑动窗口
        for (int i = k; i < len; ++i) {
            int leftIndex = i - k;
            ans[leftIndex] = treeMap.firstKey();
            //左边界i-k滑出窗，如果计数为0，清除
            treeMap.put(nums[leftIndex], treeMap.getOrDefault(nums[leftIndex], 0) - 1);
            if (treeMap.get(nums[leftIndex]) == 0) {
                treeMap.remove(nums[leftIndex]);
            }
            //添加右边界i
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        //处理最后一个滑窗
        ans[len - k] = treeMap.firstKey();
        return ans;
    }
}
