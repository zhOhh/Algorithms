package main.com.zh.algorithm.recursion_multi;

import java.util.Arrays;

/**
 * 递归求斐波那契第n项
 */
public class E01Fibonacci {

    /**
     * <h3>使用 Memoization(记忆法, 也称备忘录) 改进</h3>
     *
     * @param n 第 n 项
     * @return 第 n 项的值
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1; //[0,1,-1,-1,-1,-1,-1]
        return f(n, cache);
    }


    // f(3) => 5
    // f(4) => 9
    // f(5) => 15
    //         2*f(n+1) - 1
    public static int f(int n, int[] cache) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }

        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }




}
