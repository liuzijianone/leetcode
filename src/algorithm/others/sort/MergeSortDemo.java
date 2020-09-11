package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 11:32
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] nums = {1,3,5,9,2,4,6,8,10,5};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] array = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i;
        for (i = 0; i < array.length && p1 <= mid && p2 <= right; i++) {
            if (nums[p1] <= nums[p2]) {
                array[i] = nums[p1];
                p1++;
            } else {
                array[i] = nums[p2];
                p2++;
            }
        }

        while (p1 <= mid) {
            array[i++] = nums[p1++];
        }

        while (p2 <= right) {
            array[i++] = nums[p2++];
        }

        System.arraycopy(array, 0, nums, left, array.length);
    }
}
