package algorithm.others.lesson01;

import com.sun.scenario.effect.Brightpass;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/7 10:57
 */
public class NerthelandFlagProblem {
    public static void main(String[] args) {
        int[] nums = {5,6,8,8,8,1,5,2,7,9,10,13};
        partition(nums,0,nums.length -1,8);
        System.out.println(Arrays.toString(nums));
    }

    public static void partition(int[] nums, int left, int right, int value){
        int L = left - 1;
        int R = right + 1;
        int cur = left;
        while (cur < R){
            if (nums[cur] == value){
                cur ++;
            }
            else if (nums[cur] < value){
                swap(nums, L + 1, cur);
                L++;
                cur++;
            }else{
                swap(nums, cur, R - 1 );
                R--;
            }
        }
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
