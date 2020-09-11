package algorithm.others.lesson01;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/6 13:53
 */
public class smallSum {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5};
        System.out.println(smallSum(nums));

    }

    public static int smallSum(int[] array){
        if (array.length == 0){
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
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
                if (nums[p1] < nums[p2]) {
                    res += nums[p1] * (right - p2 +1);
                }
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
        return res;
    }
}
