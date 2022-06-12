package com.ymt.leetcode.pre_sum.find_the_longest_substring_containing_vowels_in_even_counts;

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力解法+前缀和优化:O(n^2)
 *
 * @author yumingtao
 * @date 2021/10/15 16:02
 */
public class Solution2 {
    private static final Map<Character, Integer> vowelsIndex = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('e', 1);
        put('i', 2);
        put('o', 3);
        put('u', 4);
    }};

    int[][] vowelsPSum;

    public int findTheLongestSubstring(String s) {
        int n = s.length();

        //预处理每个元音字母的前缀和
        //第一维表示元音字母在数组中的索引，第二维是该元音字母次数的前缀和
        vowelsPSum = new int[5][n + 1];
        for (int i = 1; i <= n; i++) {
            int chIndex = vowelsIndex.getOrDefault(s.charAt(i - 1), -1);
            //循环元音字母，计算前缀和
            for (int j = 0; j < vowelsIndex.size(); j++) {
                if (chIndex == j) {
                    //对匹配上元音字母+1
                    vowelsPSum[j][i] = vowelsPSum[j][i - 1] + 1;
                } else {
                    vowelsPSum[j][i] = vowelsPSum[j][i - 1];
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                //判断i～j的子串是否满足'a','e','i','o','u'全是偶数个
                if (allEvent(i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean allEvent(int start, int end) {
        //判断是否全是偶数, 时间复杂度O(5)->O(1)
        for (int i = 0; i < vowelsIndex.size(); i++) {
            int count = vowelsPSum[i][end] - vowelsPSum[i][start - 1];
            if ((count & 1) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        //String s = "abc";
        Solution2 solution2 = new Solution2();
        int ans = solution2.findTheLongestSubstring(s);
        System.out.println(ans);
    }
}
