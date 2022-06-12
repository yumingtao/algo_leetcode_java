package com.ymt.leetcode.recursion_divide_conquer.test;

/**
 * @Description
 * @author yumingtao
 * @date 2022-03-11 19:24
 */
public class Factorial {
    private int recursion(int n) {
        //终止条件
        if (n == 1) {
            return 1;
        }
        //处理逻辑和进入下一层
        return n * recursion(n - 1);
    }

    /**
     * 尾递归，函数的return语句返回的是函数的调用结果
     * 最后一次调用的返回结果，被当作当前函数的最终返回结果
     */
    private int tailRecursion(int n, int res){
        if(n == 1){
            return res;
        }
        //返回的是调用tailRecursion(n-1, n*res)的调用结果
        //n*res表示当前的n与n-1的返回结果的乘积
        return tailRecursion(n - 1, n * res);
    }

    private int cycle(int n) {
        int res = 1;
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int n = 5;
        System.out.println("factorial:" + factorial.recursion(5));
        System.out.println("tail factorial:" + factorial.tailRecursion(n, 1));
        System.out.println("cycle:" + factorial.cycle(n));
    }
}
