package algorithm.CodingInterviews.Test10;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 19:19
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
