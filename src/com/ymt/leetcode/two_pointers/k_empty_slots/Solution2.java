package com.ymt.leetcode.two_pointers.k_empty_slots;

/**
 * @Description 参考官方题解：滑动窗口
 * 1. 先假设存在k长区间[left,right]
 * 2. 判断区间内的数是否都大于left和right对应的值
 * 3. 如果2存在解，再取最小值，然后继续枚举可能存在的k长的区间
 * @author yumingtao
 * @date 2022-01-22 18:00
 */
public class Solution2 {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int[] state = new int[n];
        //将每个灯泡亮灯的时间(第几天)存入state数组
        for (int i = 0; i < n; ++i) {
            state[bulbs[i] - 1] = i + 1;
        }
        int left = 0;
        //先假设存在区间[left,right],right和left中间有k个值，即right-left=k+1
        //然后再去判断区间中的值是否都满足条件state[i]>Math.max(state[left],state[right])
        int right = left + k + 1;
        int ans = 20001;
        while (right < n) {
            boolean isValid = true;
            for (int i = left + 1; i < right; ++i) {
                if (state[i] < state[left] || state[i] < state[right]) {
                    //不满足state[i]>Math.max(state[left],state[right])，从i位置开始找k长的区间继续尝试
                    left = i;
                    right = left + k + 1;
                    isValid = false;
                    break;
                }
            }
            //如果[left,right]区间中所有的亮灯时间(第几天)都大于state[left]和state[right]
            //说明在left和right都亮灯的时候，中间的灯泡都是关闭的(因为它们的开灯时间都晚于left和right的开灯时间)，此时取left和right中最晚开灯时间(最大值)
            if (isValid) {
                ans = Math.min(ans, Math.max(state[left], state[right]));
                //从区间[right,right+k+1]开始继续寻找，最终得到最小的天数
                left = right;
                right = left + k + 1;
            }
        }
        return ans == 20001 ? -1 : ans;
    }
}
