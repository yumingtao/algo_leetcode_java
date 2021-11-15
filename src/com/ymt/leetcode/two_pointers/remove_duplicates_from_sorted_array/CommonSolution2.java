package com.ymt.leetcode.two_pointers.remove_duplicates_from_sorted_array;

/**
 * 思路：减枝优化
 * 1.将最后一个元素传到处理方法中，避免达到k个，还继续处理后边重复的元素
 *
 * @author yumingtao
 * @date 2021/11/3 16:03
 */
public class CommonSolution2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        return process(nums, 1, nums[n - 1]);
    }

    private int process(int[] nums, int k, int max) {
        int index = 0;
        for (int num : nums) {
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
            if (index > k && nums[index - k] == max) {
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5, 5, 6, 6, 6, 6};
        CommonSolution2 cs = new CommonSolution2();
        int len = cs.process(nums, 1, nums[nums.length - 1]);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
