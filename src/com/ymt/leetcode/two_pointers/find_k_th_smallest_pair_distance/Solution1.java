package com.ymt.leetcode.two_pointers.find_k_th_smallest_pair_distance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 思路：使用堆,超时
 * 1. 距离对一定是排序之后相邻的两个元素之间的距离最小，所以先对数组排序
 * 2. 排序后，所有将相邻元素对(nums[i],nums[i+1])的下标(i,i+1)放入堆中，以num[i+1]-nums[i]做为比较器，根据java小根堆的特性，
 *    每次取出来的都是距离最小的下标对
 * 3. 排序后，一定有最小的元素对(nums[i],nums[j+1])的距离大于元素对(nums[i],nums[j])的距离，在步骤2中已经将最小的(i,j)取出，
 *    那么剩下最小的是(i,j+1)，将下标对(i,j+1)放入堆中，然后再取出堆顶最小的坐标对
 * 4. 重复步骤3，直到取到第k小的坐标对
 *
 * @author yumingtao
 * @date 2022-01-11 21:27
 */
public class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(len, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return nums[o1.right] - nums[o1.left] - (nums[o2.right] - nums[o2.left]);
            }
        });
        for (int i = 0; i < len - 1; ++i) {
            queue.add(new Node(i, i + 1));
        }

        Node minNode = queue.poll();
        --k;
        while (k > 0) {
            if (minNode.right + 1 < len) {
                queue.add(new Node(minNode.left, minNode.right + 1));
            }
            minNode = queue.poll();
            --k;
        }
        return nums[minNode.right] - nums[minNode.left];
    }

    class Node {
        private int left;
        private int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
