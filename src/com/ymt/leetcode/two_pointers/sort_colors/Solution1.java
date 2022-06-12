package com.ymt.leetcode.two_pointers.sort_colors;

/**
 * 思路：快速排序思想
 * 1. 把1当成中间值，小于1的部分在1的左边，大于1的部分在1的右边
 * 2. 1本身不动
 *
 * @author yumingtao
 * @date 2021/11/17 16:57
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        int len = nums.length;

        //按照0、1、2的顺序，如果不按照顺序len<3返回
        if (len < 2) {
            return;
        }

        //[0,p0] 都是0
        //(p0,i) 都是1
        //[p2,len-1]都是2

        //循环变量i起始位置0
        int i = 0;
        //p0起始位置-1，还没有看见数组
        int p0 = -1;
        //p2起始位置len，还没有看见数组
        int p2 = len;

        while (i < p2) {
            if (nums[i] == 0) {
                p0++;
                swap(nums, i, p0);
                //if(i <= p0) i++;
                //经过多次循环，i的前边只能是1或0
                //如果是1，p0,p2都不变化，只需要i++；如果是0,说明前边都是0，i++
                i++;
            } else if (nums[i] == 1) {
                //p0,p2都不变化，只需要i++
                i++;
            } else {
                //nums[i]==2
                p2--;
                swap(nums, i, p2);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
