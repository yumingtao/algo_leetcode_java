package com.ymt.leetcode.double_pointer.two_sum_ii_input_array_is_sorted;

/**
 * 思路：双指针
 *
 * @author yumingtao
 * @date 2021/11/9 14:37
 */
public class Solution4 {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < j; i++) {
            /**
             * 固定i，当j在递减的过程中，没有找到j满足条件
             * while循环终止于i==j或是numbers[i] + numbers[j] <= target
             * 当numbers[i] + numbers[j] < target时，如果还满足i<j
             * 此时继续j--也没有意义，所以终止
             */
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            /**
             * while终止的一个条件是numbers[i] + numbers[j] = target
             * 判断i,j是否满足条件，因为元素不能重复使用，所以需要满足i<j
             */
            if (i < j && numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }

            //继续递增i，看是否有满足条件的
        }
        return new int[]{};
    }
}
