package com.ymt.leetcode.pre_sum.number_of_sub_arrays_with_odd_sum;

/**
 * 思路:
 * 偶数-奇数=奇数
 * 奇数-偶数=奇数
 * j<=i, 区间和pSum[i]-pSum[j]
 * 区间和是奇数时，ans+前边所有的偶数个数，同时ans++(本身就是奇数)
 * 区间和是偶数时，ans+前边所有的奇数个数
 * 注意每次更新奇数个数和偶数个数
 *
 * @author yumingtao
 * @date 2021/10/25 10:21
 */
public class Solution1 {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        //预处理，偶数->0,奇数->1
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] & 1) == 0 ? 0 : 1;
        }

        long ans = 0;
        long oddCount = 0;
        long eventCount = 0;
        int[] pSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];

            if (((pSum[i] & 1) == 1)) {
                //当pSum[i]是奇数的时候, 判断i之前有多少个偶数
                ans++;
                ans += eventCount;
                oddCount++;
            } else {
                //当pSum[i]是偶数的时候, 判断i之前有多少个奇数
                ans += oddCount;
                eventCount++;
            }
        }

        return (int) (ans % 1000000007);
    }
}
/**
 * 100,100,99,99
 * <p>
 * 100
 * 100, 100
 * 100, 100, 99
 * 100, 100, 99, 99
 * 100
 * 100, 99
 * 100, 99, 99
 * 99
 * 99, 99
 * 99
 * <p>
 * 1 3 5
 * 1 4 9 3 8 5
 * <p>
 * 1 1 1
 * 1 2 3
 * <p>
 * j<=i, ((pSum[i]-pSum[j]) & 1) == 1
 * <p>
 * 偶数-奇数=奇数
 * 奇数-偶数=奇数
 */