package algorithm.CodingInterviews.Test10;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 19:19
 *
 *  写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *

 */
public class Test10 {
    public static void main(String[] args) {
        System.out.println(fib(5));

    }
    public static int fib(int n) {
        int number = 0;
        if (0 == n){
            return 0;
        }else if (1 == n){
            return 1;
        }else
        {
            int first = 0;
            int second = 1;
            for (int i = 2; i <= n; i++){
                number = (first + second) % 1000000007;
                first = second;
                second = number;
            }
            return number;
        }
    }

}
