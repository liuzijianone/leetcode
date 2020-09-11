package algorithm.CodingInterviews.Test51;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 14:40
 */
public class Test51 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0 || nums.length == 1 ){
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right){
        if (left == right){
            return 0;
        }

        int mid = left + (right - left) / 2;

        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid ,right);
    }

    public static int merge(int[]nums, int left, int mid, int right){
        int[] array = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i;
        int res = 0;
        for (i = 0; i < array.length && p1 <= mid && p2 <= right; i++) {
            if (nums[p1] <= nums[p2]) {
                array[i] = nums[p1];
                p1++;
            } else {
                array[i] = nums[p2];
                res += mid - p1 + 1;
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
        return res;
    }
}
