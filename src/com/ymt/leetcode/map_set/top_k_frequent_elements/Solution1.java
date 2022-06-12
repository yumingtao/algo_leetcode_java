package com.ymt.leetcode.map_set.top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用Map+数组排序
 * @author yumingtao
 * @date 2022-03-08 19:35
 */
public class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        //统计数组中每个数字出现的频次
        Map<Integer, Pair> countMap = new HashMap<>();
        for (int num : nums) {
            Pair pair = countMap.getOrDefault(num, new Pair(num, 0));
            pair.setCount(pair.getCount() + 1);
            countMap.put(num,  pair);
        }

        Pair[] pairs = new Pair[countMap.size()];
        int index= 0;
        for(int key : countMap.keySet()){
            pairs[index++] = countMap.get(key);
        }

        Arrays.sort(pairs, ((o1, o2) -> o2.count - o1.count));
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i){
            ans[i] = pairs[i].getNum();
        }
        return ans;
    }

    class Pair{
        private int num;
        private int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
