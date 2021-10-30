package com.ymt.leetcode.array.make_sum_divisible_by_p;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yumingtao
 * @date 2021/10/30 11:05
 */
public class Solution1 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        //先计算数组的前缀和
        long[] pSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + nums[i - 1];
        }

        //(allSum-subSum)%p = 0 -> allSum % p = subSum % p = mod
        //求出allSum和subSum的共同余数，如果数组和能被整除直接返回0
        long mod = pSum[n] % p;
        if (mod == 0) {
            return 0;
        }

        //遍历前缀和数组，寻找区间和的余数是mod的最小区间
        //(pSum[i]-pSum[j])%p=mod
        //pSum[j]%p = pSum[i]%p - mod
        Map<Long, Integer> indexMap = new HashMap<>();
        //前缀和数组初始下标0放入map
        indexMap.put(0L, 0);
        //最小长度不会超过数组最大长度
        int minLen = n;
        for (int i = 1; i <= n; i++) {
            long curMod = pSum[i] % p;
            long targetMod = (curMod - mod + p) % p;
            if (indexMap.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - indexMap.get(targetMod));
                //如果已经是1，最小，直接返回
                if (minLen == 1 && minLen != n) {
                    return minLen;
                }
            }
            //更新更大的i
            indexMap.put(curMod, i);
        }

        return minLen == n ? -1 : minLen;
    }
}
