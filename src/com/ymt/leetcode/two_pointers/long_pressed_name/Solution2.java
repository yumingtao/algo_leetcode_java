package com.ymt.leetcode.two_pointers.long_pressed_name;

/**
 * 思路：题解
 *
 * @author yumingtao
 * @date 2022/2/9 10:00
 */
public class Solution2 {
    public boolean isLongPressedName(String name, String typed) {
        int indexName = 0;
        int indexTyped = 0;
        //扫描typed
        while (indexTyped < typed.length()) {
            //如果name[indexName]==typed[indexTyped],indexTyped移动，indexName移动
            if (indexName < name.length() && typed.charAt(indexTyped) == name.charAt(indexName)) {
                ++indexName;
                ++indexTyped;
            } else if (indexName > 0 && typed.charAt(indexTyped) == name.charAt(indexName - 1)) {
                //如果name[indexName-1]==typed[indexTyped],indexTyped移动，indexName不动
                ++indexTyped;
            } else {
                return false;
            }

        }
        if (indexName < name.length()) {
            return false;
        }
        return true;
    }
}
