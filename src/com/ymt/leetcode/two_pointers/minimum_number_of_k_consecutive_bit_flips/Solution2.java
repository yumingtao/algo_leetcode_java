package com.ymt.leetcode.two_pointers.minimum_number_of_k_consecutive_bit_flips;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：
 * 1. 基于贪心，遇到0都把后边k-1个元素翻转，根据异或的特性，相同得0不同得1的特性，0^1=1，1^1=0，可以与1异或完成翻转
 * 2. A[i]翻转偶数次还是A[i]，翻转奇数次是A[i]^1
 * 3. i当前的状态和前边k-1个元素翻转的次数奇偶性有关
 * 4. 使用队列模拟窗口滑动，当遍历到i位置时，前边有k-1个元素。队列表示在这k-1个元素中，从哪些位置起始的子区间进行了翻转
 * 5. 窗口滑动过程中，如果i需要翻转，则将i放入到队列中，队列中元素的个数表示当前元素被前边k-1个元素翻转的次数
 * 6. 通过2和5可知，队列长度len
 *    - 如果当前nums[i]=0并且len是偶数的时候，当前状态还是0，0是需要翻转的
 *    - 如果当前nums[i]=1并且len是奇数的时候，当前状态是0，0是需要翻转的
 *    需要翻转，则把i放入到队列中
 *
 * @author yumingtao
 * @date 2021/12/29 15:18
 */
public class Solution2 {
    public int minKBitFlips(int[] nums, int k) {
        //使用双端队列，需要pop和push
        Deque<Integer> q = new LinkedList<>();
        int count = 0;
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            //先判断在当前位置，是否需要移除队列中元素
            if(q.size() > 0 && i > q.peek() + k - 1){
                q.removeFirst();
            }
            /*if(q.size() % 2 == 0 && nums[i] == 0){
                q.add(i);
            }
            if(q.size() % 2 == 1 && nums[i] == 1){
                q.add(i);
            }*/
            //上边可以简写为如下
            if(q.size() % 2 == nums[i]){
                //当元素满足翻转条件时，当时剩余的元素不足k的长度，说明无法完成全部翻转后为1的要求
                if(i + k > len){
                    return -1;
                }
                q.add(i);
                ++count;
            }
        }
        return count;
    }
}
