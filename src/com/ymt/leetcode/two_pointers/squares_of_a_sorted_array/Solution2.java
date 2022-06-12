package com.ymt.leetcode.two_pointers.squares_of_a_sorted_array;

import java.util.PriorityQueue;

/**
 * 思路：利用优先队列
 *
 * @author yumingtao
 * @date 2022/2/9 14:36
 */
public class Solution2 {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums){
            queue.add(num * num);
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (!queue.isEmpty()){
            ans[index++] = queue.poll();
        }
        return ans;
    }
}
