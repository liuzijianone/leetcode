package algorithm.others.lesson01;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 11:19
 */
public class basic01 {
    public static void main(String[] args) {
        int[] nums = {5,6,8,1,10,5,8,9};
        System.out.println(getMax(nums, 0, nums.length - 1));

    }

    public static int getMax(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        int mid = left + (right - left) /2;
        int leftMax = getMax(nums,0, mid);
        int rightMax = getMax(nums,mid + 1, right);

        return Math.max(leftMax, rightMax);
    }
}
