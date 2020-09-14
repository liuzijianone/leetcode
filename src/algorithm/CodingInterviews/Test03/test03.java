package algorithm.CodingInterviews.Test03;

import sun.awt.windows.WPrinterJob;

import java.lang.reflect.Array;
/**
  * @author liuzijian
  * @since 2020/9/14 16:09
  * @version 1.0
  * @param
  * @return
  *  找出数组中重复的数字。
  *
  *
  * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
  * 请找出数组中任意一个重复的数字。
  *
  * 示例 1：
  *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *

  */


public class test03  {

    public static int findRepeatNumber(int[] nums) {
        int count[] = new int[nums.length];
        int j = -1;
        for(int i =0; i < count.length; i++){
            count[i] = 0;
        }

        for(int i = 0; i < nums.length; i++){
            count[nums[i]] += 1;
        }

        for(int i = 0; i<count.length; i++){
            if(count[i] > 1){
                j = i;
                break;
            }
        }

        return j;

    }
    public  static void main(String[] args) {
        int []num = {1,1,3,4,2};
        System.out.println(findRepeatNumber(num));

    }

}



