package com.ymt.leetcode.string.ransom_note;

/**
 * @description
 * @author yumingtao
 * @date 2022-10-06 12:22
 */
public class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] mCount = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            mCount[magazine.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < ransomNote.length(); ++i) {
            int mIndex = ransomNote.charAt(i) - 'a';
            if (mCount[mIndex] == 0) {
                return false;
            } else {
                mCount[mIndex] -= 1;
            }
        }

        return true;
    }
}
