package com.ymt.leetcode.delete_columns_to_make_sorted;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-28 20:49
 */
public class Solution1 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int ans = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 1; j < m; ++j){
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
}
