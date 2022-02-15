package com.ymt.leetcode.two_pointers.meeting_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description Solution1代码优化
 * @author yumingtao
 * @date 2022-02-12 17:19
 */
public class Solution2 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //对slots1按照开始时间进行排序
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
        //对slots2按照开始时间进行排序
        Arrays.sort(slots2, (Comparator.comparingInt(o -> o[0])));
        int index1 = 0;
        int index2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (index1 < slots1.length && index2 < slots2.length){
            //如果有交叠，则必然会有start1在[start2,end2]区间或start2在[start1,end1]区间
            //判断end1在[start2,end2]区间或end2在[start1,end1]区间也是一样的
            //这样的判断覆盖了区间重叠不包含和区间包含的情况
            if((slots1[index1][0] >= slots2[index2][0] && slots1[index1][0] <= slots2[index2][1])
                || slots2[index2][0] >= slots1[index1][0] && slots2[index2][0] <= slots1[index1][1]){
                //找到最晚的start
                int maxStart = Math.max(slots1[index1][0], slots2[index2][0]);
                //找到最晚的end
                int minEnd = Math.min(slots1[index1][1], slots2[index2][1]);
                //[maxStart, minEdn]就是交叠的时间区间
                if(maxStart + duration <= minEnd){
                    ans.add(maxStart);
                    ans.add(maxStart + duration);
                    break;
                }
            }
            //没有交叠或有交叠但不满足duration时，需要移动end值小的指针
            if(slots1[index1][1] < slots2[index2][1]){
                //slots2的end比较大，有可能和slots1的下一个区间有交叠，移动index1
                if(index1 != slots1.length - 1){
                    ++index1;
                }else {
                    //到了数组的末尾
                    break;
                }
            }else if(slots1[index1][1] > slots2[index2][1]){
                //slots1的end比较大，有可能和slots2的下一个区间有交叠，移动index2
                if(index2 != slots2.length) {
                    ++index2;
                }else {
                    //到了数组的末尾
                    break;
                }
            }else{
                //如果相等，考虑同时移动index1和index2
                if(index1 != slots1.length - 1 && index2 != slots2.length - 1){
                    ++index1;
                    ++index2;
                }else  if(index1 == slots1.length - 1){
                    ++index2;
                }else {
                    ++index1;
                }
            }
        }
        return ans;
    }
}
