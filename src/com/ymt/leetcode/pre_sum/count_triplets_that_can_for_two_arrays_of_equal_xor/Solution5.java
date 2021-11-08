package com.ymt.leetcode.pre_sum.count_triplets_that_can_for_two_arrays_of_equal_xor;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：针对Solution4减少一次循环
 * a = pXor[j-1]^pXor[i-1]
 * b = pXor[k]^pXor[j-1]
 * a=b -> pXor[j-1]^pXor[i-1]=pXor[k]^pXor[j-1]
 * pXor[i-1]=pXor[k]
 * i-1>=0 -> 1<=i<k
 *
 * @author yumingtao
 * @date 2021/10/24 18:21
 */
public class Solution5 {
    public int countTriplets(int[] arr) {
        int n = arr.length;

        //记录上一个前缀xor
        int pXor = 0;
        int ans = 0;

        //对于下标k，若i1,i2,...im满足条件pXor[i-1]=pXor[k]
        //ans=(k-i1)+(k-i2)+...(k-im)=m*k-(i1+i2+i3+i4)

        //满足pXor[i-1]=pXor[k]出现的次数
        Map<Integer, Integer> iCount = new HashMap<>();
        //满足pXor[i-1]=pXor[k]时，所遍历过的下标之和
        Map<Integer, Integer> iSum = new HashMap<>();

        //因为在下一个for中要判断pXor[i-1]=pXor[k]的次数，所以不能提前初始化iCount和iSum
        //遍历pXor，当遍历到k的时候，判断在k之前是否存在等于pXor[k]的数值
        //如果存在，
        //  1.计算公式ans=(k-i1)+(k-i2)+...(k-im)=m*k-(i1+i2+i3+i4)
        //  2.初始化k-1的，iCount和iSum
        //注意 1 和 2 没有顺序
        for (int i = 1; i <= n; i++) {
            //初始化iCount和iSum
            iCount.put(pXor, iCount.getOrDefault(pXor, 0) + 1);
            iSum.put(pXor, iSum.getOrDefault(pXor, 0) + i);
            pXor ^= arr[i - 1];

            if (iCount.containsKey(pXor)) {
                ans += iCount.get(pXor) * i - iSum.get(pXor);
            }
        }

        return ans;
    }
}
