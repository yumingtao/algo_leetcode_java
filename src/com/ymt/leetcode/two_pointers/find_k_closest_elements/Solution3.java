package com.ymt.leetcode.two_pointers.find_k_closest_elements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 思路：题解-直接使用Collections.sort()
 *
 * @author yumingtao
 * @date 2022/2/10 09:11…
 */
public class Solution3 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //首先将数组转换为list
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //对数组进行排序
        Collections.sort(list, (o1, o2) -> o1.intValue() == o2.intValue() ? o1.intValue() - o2.intValue() :
                Math.abs(o1 - x) - Math.abs(o2 - x));
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
