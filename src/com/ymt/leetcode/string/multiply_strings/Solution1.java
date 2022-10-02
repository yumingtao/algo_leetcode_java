package com.ymt.leetcode.string.multiply_strings;

/**
 * @description 参考题解思路实现
 * @author yumingtao
 * @date 2022-10-02 15:00
 */
public class Solution1 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //使用数组保存每一位成绩+进位的结果，先确定数组的长度
        //num1长度m，num2长度n
        //都取最小值：num1的最小值10的m-1次方，num2的最小值10的n-1次方，乘积长度：10的m+n-2次方，即m+n-1
        //都取最大值：num1的最小值10的m次方-1，num2的最小值10的n次方-1，乘积长度：10的m+n次方-10的m次方-10的n次方+1，显然大于10的m+n-1次方而小于10的m+n次方，所以最大长度m+n
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];
        //num1作为被乘数，num2作为乘数
        for (int i = n - 1; i >= 0; --i) {
            int ch2 = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; --j) {
                int ch1 = num1.charAt(j) - '0';
                //从后往前，i+j+1是当前位置
                int res = ch2 * ch1 + ansArr[i + j + 1];
                //当前位置的值是int[i+j+1]+res的mod
                ansArr[i + j + 1] = res % 10;
                int val = res / 10;
                int k = 1;
                while (val != 0) {
                    int tmp = ansArr[i + j + 1 - k] + val;
                    ansArr[i + j + 1 - k] = tmp % 10;
                    val = tmp / 10;
                    k++;
                }
            }
        }
        //注意去掉最高位的0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ansArr.length; ++i) {
            if (i == 0 && ansArr[i] == 0) {
                continue;
            }
            sb.append(String.valueOf(ansArr[i]));
        }
        return sb.toString();
    }
}
