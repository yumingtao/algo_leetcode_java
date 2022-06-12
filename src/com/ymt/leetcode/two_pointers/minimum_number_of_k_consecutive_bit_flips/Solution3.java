package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

/**
 * 思路：差分数组
 * 1. 对一个区间做翻转，利用差分的思想，diff差分数组表示相邻元素nums[i-1]和nums[i]之间翻转的次数差（这是差分数组的定义），
 *    [l,r]多次操作产生的影响是diff[l]+1,diff[r]-1，累加差分数组可以得到当前元素i的翻转次数（即差分数组的前缀和是原数组的特性）
 * 2. 如果元素是0，则需要翻转，有如下的规则
 *  - 当前元素翻转的次数是奇数时，并且当前元素是1的时候，经过奇数次翻转变成0，需要再次翻转
 *  - 当前元素翻转的此时是偶数时，并且当前元素是0的时候，经过偶数次翻转变成0，需要再次翻转
 *  总结：翻转次数+当前元素的值=偶数，则需要翻转；也可以翻转次数%2=当前元素值
 *
 * @author yumingtao
 * @date 2021/12/30 16:19
 */
public class Solution3 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        int[] diff = new int[len + 1];
        //当前位置翻转的次数
        int revertCount = 0;
        int ans =0;
        for(int i = 0; i < len; ++i){
            //此处相当于对diff差分数组求前缀和的优化
            revertCount += diff[i];
            if(revertCount % 2 == nums[i]){
                //剩下的长度无法完成一次翻转
                if(i + k > len){
                    return -1;
                }
                ++revertCount;
                --diff[i + k];
                ++ans;
            }
        }
        return ans;
    }
}
