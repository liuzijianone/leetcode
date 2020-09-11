package algorithm.CodingInterviews.Test17;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 18:59
 */
public class Test17 {

    public static void main(String[] args) {
        printNumbers(3);

    }
    public static int[] printNumbers(int n) {
        int[] nums = new int[(int) Math.pow(10, n)];
        for (int i = 0; i < Math.pow(10, n) ; i++){
            nums[i] = i;
        }
        return nums;
    }
}
