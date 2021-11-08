package com.ymt.leetcode.pre_sum.find_the_longest_substring_containing_vowels_in_even_counts;

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力解法+遍历子串优化
 * 1.假设j<=i,若在子串s[j...i]中，某个元音字母出现的次数pSum[i]-pSum[j-1]
 * 2.根据奇数-奇数/偶数-偶数的结果才是偶数的特性，说明在s[0...j-1]和s[0...i]中必须具有相同的奇偶性
 * 3.此时不需要再计算前缀和，通过map存储第一次出现个数为奇数或偶数的下标index
 * 4.遍历字符串时，如果该元音和map中的奇偶性相同，则计算长度的i-index+1
 *
 * @author yumingtao
 * @date 2021/10/15 16:02
 */
public class Solution3 {
    public int findTheLongestSubstring(String s) {
        //默认值是0，此时字符串中不包含元音字母
        int ans = 0;

        VowelsStatus vowelsStatus = new VowelsStatus();
        Map<String, Integer> statusIndex = new HashMap<>();
        String currentKey = vowelsStatus.generateHashKey();

        //默认都是偶数，index初始值设置为-1
        statusIndex.put(currentKey, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果是元音字母,将奇偶性取反
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                //反转字母的奇偶性
                vowelsStatus.revertStatus(ch);
                currentKey = vowelsStatus.generateHashKey();
                //判断之前是否有和当前奇偶性一致的状态,没有则更新
                if (!statusIndex.containsKey(currentKey)) {
                    //存储第一次出现该状态的index
                    statusIndex.put(currentKey, i);
                }
            }
            //更新ans
            ans = Math.max(ans, i - statusIndex.get(currentKey));
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        //String s = "leetcodeisgreat";
        //String s = "bcbcbc";
        Solution3 solution3 = new Solution3();
        int ans = solution3.findTheLongestSubstring(s);
        System.out.println(ans);
    }
}

class VowelsStatus {
    /**
     * 因为开始个数都是0，所以默认都是偶数,所以初始值都是false
     */
    private boolean aIsOdd;
    private boolean eIsOdd;
    private boolean iIsOdd;
    private boolean oIsOdd;
    private boolean uIsOdd;

    public void revertStatus(char ch) {
        if ('a' == ch) {
            aIsOdd = !aIsOdd;
        }

        if ('e' == ch) {
            eIsOdd = !eIsOdd;
        }

        if ('i' == ch) {
            iIsOdd = !iIsOdd;
        }

        if ('o' == ch) {
            oIsOdd = !oIsOdd;
        }

        if ('u' == ch) {
            uIsOdd = !uIsOdd;
        }
    }

    public String generateHashKey() {
        return String.format("%s_%s_%s_%s_%s", aIsOdd, eIsOdd, iIsOdd, oIsOdd, uIsOdd);
    }
}
