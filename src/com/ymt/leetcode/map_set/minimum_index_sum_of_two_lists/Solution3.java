package com.ymt.leetcode.map_set.minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：题解，枚举sum<=list1.length+list2.length-2
 *
 * @author yumingtao
 * @date 2022/2/28 18:14
 */
public class Solution3 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        for (int sum = 0; sum <= list1.length + list2.length - 2; ++sum) {
            //因为求i+j=sum，所以i的取值区间[0,sum]
            for (int i = 0; i <= sum; ++i) {
                int j = sum - i;
                if (i < list1.length && j < list2.length && list1[i].equals(list2[j])) {
                    ans.add(list1[i]);
                }
            }
            if (ans.size() > 0) {
                break;
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
