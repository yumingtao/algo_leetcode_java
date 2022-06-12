package com.ymt.leetcode.two_pointers.boats_to_save_people;

import java.util.Arrays;

/**
 * @Description Solution1代码优化
 * @author yumingtao
 * @date 2022-02-08 21:13
 */
public class Solution2 {
    public int numRescueBoats(int[] people, int limit) {
        //首先按人的体重进行排序
        Arrays.sort(people);
        //指向剩余人中最轻的
        int left = 0;
        //指向剩余人中最重的
        int right = people.length - 1;
        int ans = 0;
        while (left <= right) {
            //先处理最重的人
            if (people[left] + people[right] <= limit) {
                //最重的人和最轻的人如果可以一起乘船
                //left移到下一个最轻的人
                ++left;
                ++ans;
            }
            //最重的人不能和最轻的人一起乘船，让最重的人只能单独乘船
            --right;
            ++ans;
        }
        return ans;
    }
}
