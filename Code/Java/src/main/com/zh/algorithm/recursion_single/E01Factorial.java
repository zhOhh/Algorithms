package main.com.zh.algorithm.recursion_single;

/**
 * 递归求阶乘
 */
public class E01Factorial {

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }

        return n * (n - 1);
    }

    public static void main(String[] args) {
        int n = f(5);
        System.out.println(n);
    }

}
