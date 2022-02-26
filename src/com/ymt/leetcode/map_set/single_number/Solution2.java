package com.ymt.leetcode.map_set.single_number;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description 使用HashSet
 * 1. 因为只有一个元素出现一次，其余元素均出现两次，可以想象成消消乐，相同元素消除掉
 * 2. 利用HashSet来消除相同元素，最终剩下的就是指出现一次的元素
 * @author yumingtao
 * @date 2022-02-26 16:31
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            return it.next();
        }
        return Integer.MAX_VALUE;
    }
}
