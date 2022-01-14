package com.ymt.leetcode.two_pointers.find_k_th_smallest_pair_distance;

import java.util.Arrays;

/**
 * @Description 二分+双指针
 * @author yumingtao
 * @date 2022-01-13 20:59
 */
public class Solution3 {
    public int smallestDistancePair(int[] nums, int k) {
        //先对数组升序
        Arrays.sort(nums);
        int len = nums.length;
        int low = 0;
        int high = nums[len - 1] - nums[0];
        while (low < high){
            int mid = (high + low) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < len; ++right){
                while (nums[right] - nums[left] > mid){
                    //说明左边界小了，需要移动左边界，直到再次满足条件
                    ++left;
                }
                //相当于固定左边界，然后找右边届，右边届和左边界之间的距离对都满足
                //注意固定left，right到left能够组成的距离对个数是right-left
                count += right - left;
            }
            if(count >= k){
                //说明找的数量多了，mid的值大了,说明要找的mid还在左边
                high = mid;
            }else {
                //要找的mid一定还在右边
                low = mid + 1;
            }
        }
        return low;
    }
}
