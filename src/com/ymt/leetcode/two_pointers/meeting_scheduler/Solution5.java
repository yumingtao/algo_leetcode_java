package com.ymt.leetcode.two_pointers.meeting_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @author yumingtao
 * @date 2022-02-12 19:38
 */
public class Solution5 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //对slots1按照开始时间进行排序
        Arrays.sort(slots1, (o1, o2) -> o1[0] - o2[0]);
        //对slots2按照开始时间进行排序
        Arrays.sort(slots2, (o1, o2) -> o1[0] - o2[0]);
        int index1 = 0;
        int index2 = 0;
        while (index1 < slots1.length && index2 < slots2.length) {
            //找到最晚的start
            int maxStart = Math.max(slots1[index1][0], slots2[index2][0]);
            if (slots1[index1][1] <= slots2[index2][1]) {
                if (maxStart + duration <= slots1[index1][1]) {
                    //有交叠，[maxStart, slots1[index1][1]]就是交叠的时间区间
                    return Arrays.asList(maxStart, maxStart + duration);
                }
                //没有交叠或有交叠但不满足duration时，需要移动end值小的指针
                //slots2的end比较大，有可能和slots1的下一个区间有交叠，移动index1
                ++index1;
            } else {
                if (maxStart + duration <= slots2[index2][1]) {
                    //有交叠，[maxStart, slots2[index2][1]]就是交叠的时间区间
                    return Arrays.asList(maxStart, maxStart + duration);
                }
                //没有交叠或有交叠但不满足duration时，需要移动end值小的指针
                //slots1的end比较大，有可能和slots2的下一个区间有交叠，移动index2
                ++index2;
            }
        }
        return new ArrayList<>();
    }
}
