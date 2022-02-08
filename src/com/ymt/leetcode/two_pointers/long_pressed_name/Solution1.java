package com.ymt.leetcode.two_pointers.long_pressed_name;

/**
 * @Description 双指针
 * @author yumingtao
 * @date 2022-02-08 21:19
 */
public class Solution1 {
    public boolean isLongPressedName(String name, String typed) {
        int rightName = name.length() - 1;
        int rightTyped = typed.length() - 1;
        //从右往左遍历name和typed
        while (rightName >= 0 || rightTyped >= 0) {
            //记录name中重复出现的字母计数
            int nameLetterRepeatCount = 0;
            //记录typed中重复出现的字母计数
            int rightTypedRepeatCount = 0;
            //找到name最右侧不重复的母，并统计字母重复计数
            while (rightName > 0 && name.charAt(rightName) == name.charAt(rightName - 1)) {
                --rightName;
                ++nameLetterRepeatCount;
            }
            //找到typed最右侧不重复的母，并统计字母重复计数
            while (rightTyped > 0 && typed.charAt(rightTyped) == typed.charAt(rightTyped - 1)) {
                --rightTyped;
                ++rightTypedRepeatCount;
            }
            //如果同一个字母，type中重复出现的个数小于name中重复出现的个数，name和typed必然不相等，直接返回false
            if (rightTypedRepeatCount < nameLetterRepeatCount) {
                return false;
            }
            //如果同一个字母，type中重复出现的个数大于等于name中重复出现的个数
            if (rightName >= 0 && rightTyped >= 0) {
                //如果两个指针都有效，判断字母是否相等
                if (typed.charAt(rightTyped) != name.charAt(rightName)) {
                    return false;
                }
            } else {
                ///如果其中只有一个指针都有效，说明name和typed某个字符串中还有字母没有比较，name和typed必然不相等，直接返回false
                if (rightName >= 0 || rightTyped >= 0) {
                    return false;
                }
            }
            //向左继续移动两个指针
            --rightName;
            --rightTyped;
        }
        return true;
    }
}
