package com.ymt.leetcode.two_pointers.number_of_substrings_containing_all_three_characters;

/**
 * @Description 滑窗+计数
 * 1. 先找到字符串刚好满组a,b,c都至少出现1次的位置，做为右边界right
 * 2. 此时从right开始到字符s结尾所组成的字串都满足条件，计算可以组成子串的个数len-right，做为对解的贡献累加到ans
 * 3. 向右不断移动left，如果字符串依然满足a,b,c都至少出现1次，累加可以组成子串的个数len-right
 * 4. 当字符串不满足a,b,c都至少出现1次时，停止移动left，向右继续移动right，寻找下一次满足条件的右边界right，重复步骤2，3，4直到right到达s结尾
 *
 * @author yumingtao
 * @date 2022-01-10 20:15
 */
public class Solution1 {
    public int numberOfSubstrings(String s) {
        int[] frequency = new int[3];
        int count = 0;
        char[] chs = s.toCharArray();
        int left = 0;
        int ans = 0;
        int len = s.length();
        for(int right = 0; right < len; ++right){
            int rChIndex = chs[right] - 'a';
            if(frequency[rChIndex] == 0){
                ++count;
            }
            ++frequency[rChIndex];
            while(left < right && count == 3){
                //len-1-right+1 -> len-right
                ans += len - right;
                int lChIndex = chs[left] - 'a';
                --frequency[lChIndex];
                if(frequency[lChIndex] == 0){
                    --count;
                }
                ++left;
            }
        }
        return ans;
    }
}
