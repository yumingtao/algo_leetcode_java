package com.ymt.leetcode.pre_sum.can_make_palindrome_from_substring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yumingtao
 * @date 2021/10/5 18:12
 */
public class Solution1 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();
        //预处理，统计字符串s中每个字母出现的次数
        //使用一个二维数组letterCount[i][26],表示字符串位置i时刻，26个字母分别出现的次数
        //第i个字母在区间出现的次数letterCount[right][i]-letterCount[left-1][i]
        //因为有left-1，为了left可以从0开始，所以可以使letterCount的长度为len+1，left=0时，所有字母的统计个数都是0
        //此时第i个字母在区间出现的次数letterCount[right+1][i]-letterCount[left][i]
        int[][] letterCount = new int[len + 1][26];
        for(int i = 1; i <= len; i++){
            //当前字母在letterCount[i]数组中的索引,字母a的下标为0
            int letterIndex = s.charAt(i - 1) - 'a';
            letterCount[i][letterIndex]++;

            //遍历计算前缀和
            for(int j = 0; j < 26; j++){
                letterCount[i][j] += letterCount[i - 1][j];
            }
        }

        List<Boolean> ans = new ArrayList<>();
        //遍历queries
        for(int[] q : queries){
            int left = q[0];
            int right = q[1];
            int k = q[2];

            //计算在区间[left,right]上各个字母出现个数
            //第i个字母在区间出现的次数letterCount[right+1][i]-letterCount[left][i]
            int[] subLetterCount = new int[26];
            //出现次数为奇数的字母的个数
            int oddCount = 0;
            for(int i = 0; i < 26; i++){
                subLetterCount[i] = letterCount[right + 1][i] - letterCount[left][i];
                //统计出现次数为奇数的字母的个数
                if(subLetterCount[i] % 2 == 1){
                    oddCount++;
                }
            }

            //当子字符串的长度为偶数时oddCount/2<=k
            //当子字符串的长度为奇数时(oddCount-1)/2<=k
            //只需要oddCount除以2向下取整<=k, 则可以通过重排和替换变成回文
            if(oddCount / 2 <= k){
                ans.add(Boolean.TRUE);
            }else{
                ans.add(Boolean.FALSE);
            }
        }

        return ans;
    }
}
