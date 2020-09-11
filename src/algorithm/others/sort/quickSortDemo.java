package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/7 14:45
 */
public class quickSortDemo {
    public static void main(String[] args) {
        int[] array = {4,7,8,5,9,10,20,15,6};
        quickSort(array,0, array.length -1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left < right){
            swap(nums, (int) (left + (Math.random() * (right - left + 1))), right);
            int[] partition =partition(nums, left, right);
            quickSort(nums, left, partition[0]);
            quickSort(nums, partition[1], right);

        }

    }


    public static int[] partition(int[] nums, int left, int right){
        int L = left - 1;
        int R = right;
        int cur = left;
        while (cur < R){
            if (nums[cur] < nums[right]){
                swap(nums, cur, ++L);
                cur ++ ;
            }else if (nums[cur] == nums[right]){
                cur++;
            }else{
                swap(nums, cur, --R);
            }
        }
        swap(nums, right,R);
        return new int[] {L, R+1};
    }

    public static void swap(int[] nums, int i, int j){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
