package com.ymt.leetcode.two_pointers.meeting_scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 思路：
 *
 * @author yumingtao
 * @date 2022/2/11 15:11
 */
public class Solution1 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //对slots1按照开始时间进行排序
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
        //对slots2按照开始时间进行排序
        Arrays.sort(slots2, (Comparator.comparingInt(o -> o[0])));
        int index1 = 0;
        int index2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (index1 < slots1.length && index2 < slots2.length){
            //判断是否有交叠
            if(slots1[index1][1] < slots2[index2][0]){
                //slots1的end小于slots2的start，slots1和slots2没有交叠情况，移动index1
                if(index1 != slots1.length - 1){
                    ++index1;
                }else {
                    //不会再有交叠
                    break;
                }
            }else if(slots2[index2][1] < slots1[index1][0]){
                //slots2的end小于slots1的start，slots2和slots1没有交叠情况，移动index2
                if(index2 != slots2.length - 1) {
                    ++index2;
                }else {
                    //不会再有交叠
                    break;
                }
            }else{
                //有交叠的情况
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

                //有交叠，但是不满足duration，考虑移动index1还是移动index2
                //谁的end小就移动谁
                if(slots1[index1][1] < slots2[index2][1]){
                    //slots2的end比较大，有可能和slots1的下一个区间有交叠，移动index1
                    if(index1 != slots1.length - 1){
                        ++index1;
                    }else {
                        //不会再有交叠
                        break;
                    }
                }else if(slots1[index1][1] > slots2[index2][1]){
                    //slots1的end比较大，有可能和slots2的下一个区间有交叠，移动index2
                    if(index2 != slots2.length) {
                        ++index2;
                    }else {
                        //不会再有交叠
                        break;
                    }
                }else{
                    //如果相等，考虑同时移动index1和index2
                    if(index1 != slots1.length - 1 && index2 != slots2.length - 1){
                        ++index1;
                        ++index2;
                    }else {
                        //只要有一个到达数组末尾，就break
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
