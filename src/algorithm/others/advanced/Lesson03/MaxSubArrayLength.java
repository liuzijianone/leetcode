package algorithm.others.advanced.Lesson03;

import java.util.HashMap;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/11/1 11:34
 */
public class MaxSubArrayLength {
    public static void main(String[] args) {
        int[] array = {7,7,7,3,2,1,1,7,7};
        System.out.println(maxLength(array, 7));

    }

    public static int maxLength(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum= 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                len = Math.max(i - map.get(sum - k), len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return  len;
    }
}
