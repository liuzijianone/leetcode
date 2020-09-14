package algorithm.CodingInterviews.Test17;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 18:59
 *
 *  输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
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
