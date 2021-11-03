package com.ymt.leetcode.array.remove_duplicates_from_sorted_array;

/**
 * 思路：
 * 1.index表示当前索引，index-k表示当前相同元素x的起始位置索引，如果不同，更新nums[index]
 *
 * @author yumingtao
 * @date 2021/11/3 15:21
 */
public class CommonSolution1 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 1);
    }

    private int process(int[] nums, int k) {
        int index = 0;
        for (int num : nums) {
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5, 5, 6, 6, 6, 6};
        CommonSolution1 cs = new CommonSolution1();
        int len = cs.process(nums, 2);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
