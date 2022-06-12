package com.ymt.leetcode.map_set.top_k_frequent_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description 题解：使用HashMap和堆
 * @author yumingtao
 * @date 2022/3/9 09:22
 */
public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        //统计每个数字出现的频次
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }

        //使用小根堆存放二维数组，[][0]代表数字，[][1]代表数字的频次
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //遍历map
        for (int key : frequents.keySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{key, frequents.get(key)});
            } else if (queue.size() == k && queue.peek()[1] < frequents.get(key)) {
                queue.poll();
                queue.offer(new int[]{key, frequents.get(key)});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
