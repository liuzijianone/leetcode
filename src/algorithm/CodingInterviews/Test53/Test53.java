package algorithm.CodingInterviews.Test53;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/5 19:59
 */
public class Test53 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,8,8,8,8,10,15,16};
        System.out.println(search(nums,16));

    }

    public static int search(int[] nums, int target){
        if (nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        int leftIndex;
        int rightIndex;


        // 右侧边界
        while (left <= right){

            int mid = left + (right - left)/ 2;
            if (nums[mid] == target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        if (right < 0 ||  nums[right] != target){
            return 0;
        }


        rightIndex = right;

        left = 0;
        right = nums.length -1;

        // 右侧边界
        while (left <= right){
            int mid  = left + (right - left)/ 2;
            if (nums[mid] == target){
                right = mid - 1;
            }
            else if (nums[mid] > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        if (left >= nums.length ||  nums[left] != target){
            return 0;
        }

        leftIndex = left;

        return rightIndex - leftIndex + 1 ;

    }
}
