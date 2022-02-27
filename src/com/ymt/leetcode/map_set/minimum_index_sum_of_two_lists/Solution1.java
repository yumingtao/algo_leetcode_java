package com.ymt.leetcode.map_set.minimum_index_sum_of_two_lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-02-27 16:28
 */
public class Solution1 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //预处理，先将list1中的餐厅名称和索引存放在map中
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map1.put(list1[i], i);
        }

        HashSet<String> sameSet = new HashSet<>();
        int minSum = 2001;
        for (int i = 0; i < list2.length; ++i) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                if (sum > minSum) {
                    continue;
                } else if (sum < minSum) {
                    minSum = sum;
                    sameSet.clear();
                }
                //因为所有字符串都是唯一，所以不需要判断是否存在，直接添加
                sameSet.add(list2[i]);
            }
        }
        Iterator<String> it = sameSet.iterator();
        String[] ans = new String[sameSet.size()];
        int i = 0;
        while (it.hasNext()) {
            ans[i++] = it.next();
        }
        return ans;
    }
}
