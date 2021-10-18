package com.ymt.leetcode.array.find_the_longest_substring_containing_vowels_in_even_counts;

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力解法:O(n^3)
 *
 * @author yumingtao
 * @date 2021/10/15 16:02
 */
public class Solution1 {
    private static final Map<Character, Integer> vowelsIndex = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('e', 1);
        put('i', 2);
        put('o', 3);
        put('u', 4);
    }};

    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //判断i～j的子串是否满足'a','e','i','o','u'全是偶数个
                if (isAllEvent(s.substring(i, j + 1))) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean isAllEvent(String str) {
        int[] vowelsCounts = new int[vowelsIndex.size()];
        for (char ch : str.toCharArray()) {
            int index = vowelsIndex.getOrDefault(ch, -1);
            if (index != -1) {
                vowelsCounts[index]++;
            }
        }
        //System.out.println(Arrays.stream(vowelsCounts).boxed().collect(Collectors.toList()));

        //判断是否全是偶数
        for (int i = 0; i < vowelsIndex.size(); i++) {
            if ((vowelsCounts[i] & 1) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        //String s = "abc";
        Solution1 solution1 = new Solution1();
        int ans = solution1.findTheLongestSubstring(s);
        System.out.println(ans);
    }
}
