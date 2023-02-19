package com.ymt.leetcode.two_pointers.sliding_window_maximum;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 思路:使用TreeMap
 *
 * @author yumingtao
 * @date 2022/1/14 12:20
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //TreeMap默认是按key升序，需要提供比较器,key:nums[i],value:nums[i]的计数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.intValue() - o1.intValue());
        //先初始k大小的滑动窗口
        for (int i = 0; i < k; ++i) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        //向右滑动窗口
        for (int i = k; i < nums.length; ++i) {
            list.add(treeMap.firstKey());

            //左边界i-k滑出窗，如果计数为0，清除
            int leftIndex = i - k;
            treeMap.put(nums[leftIndex], treeMap.getOrDefault(nums[leftIndex], 0) - 1);
            if (treeMap.get(nums[leftIndex]) == 0) {
                treeMap.remove(nums[leftIndex]);
            }
            //添加右边界i
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        //处理最后一个滑窗
        list.add(treeMap.firstKey());

        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; ++i){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
