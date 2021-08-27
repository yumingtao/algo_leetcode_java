package com.ymt.offer.shu_zu_zhong_zhong_fu_de_shu_zi_lcof;

/**
 * @author yumingtao
 * @date 2021/8/27 13:43
 */
public class Solution4 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) return -1;
        }

        /**
         * 0～n-1个数，如果不重复，排序后第i个位置上的数值就应该是i本身
         * 如果不是i本身，不断的将nums[i]的值通过交换，放到i位置上
         * 在交换的过程中，发现某一个num[i] == nums[nums[i]],说明重复了
         */
        for (int i = 0; i < n; i++) {
            //当某个i没有出现在数组的值中时，会一直while循环，直到找到结果
            while (nums[i] != i) {
                //System.out.println("i:" + i + ", nums[i]:" + nums[i]);
                //System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                if (nums[i] == nums[nums[i]]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {4, 5, 7, 6, 3, 2, 0, 5, 3};
        int[] nums = {7, 6, 5, 4, 3, 2, 1, 0};
        Solution4 solution = new Solution4();
        System.out.println(solution.findRepeatNumber(nums));
    }
}
