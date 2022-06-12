package com.ymt.leetcode.map_set.two_sum_iii_data_structure_design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 使用List
 * @author yumingtao
 * @date 2022-03-06 14:19
 */
public class TwoSum2 {
    private List<Integer> data;
    private boolean isSorted;

    public TwoSum2() {
        data = new ArrayList<>();
    }

    public void add(int number) {
        data.add(number);
        isSorted = false;
    }

    public boolean find(int value) {
        if (!isSorted) {
            Collections.sort(data);
            isSorted = true;
        }
        int left = 0;
        int right = data.size() - 1;
        while (left < right) {
            if (data.get(left) + data.get(right) < value) {
                ++left;
            } else if (data.get(left) + data.get(right) > value) {
                --right;
            } else {
                return true;
            }
        }
        return false;
    }
}
