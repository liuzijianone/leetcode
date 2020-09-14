package algorithm.CodingInterviews.Test11;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/3 20:18
 *
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 */
public class Test11 {
    public static void main(String[] args) {
//        int[] array = {0,0,1,0,0};
        int[] array = {3,3,2,2,3};
        System.out.println(minArray(array));
    }
//    public static int minArray(int[] numbers) {
//        int left = 0;
//        int right = numbers.length - 1;
//        int mid = (left + right) / 2;
//
//        if (numbers[left] < numbers[right]){
//            return numbers[left];
//        }
//
//        while (left < right){
//
//            if (numbers[right] < numbers[mid]){
//                left = mid + 1 ;
//            }
//            else if (numbers[mid] < numbers[right]){
//                right = mid ;
//            }else{
//                right -=1;
//            }
//
//            mid = (left + right) / 2;
//        }
//        return numbers[left] ;
//    }

        public static int minArray(int[] numbers) {
            int left = 0;
            int right = numbers.length - 1;
            int mid = (left + right) / 2;

            if (numbers[left] < numbers[right]){
                return numbers[left];
            }

            while (left < right){
                if (numbers[right] < numbers[mid]){
                    left = mid + 1 ;
                }
                else if (numbers[mid] < numbers[right]){
                    right = mid;
                }else if (numbers[mid] == numbers[right]){
                    right = right - 1;
                }
                mid = (left + right) / 2;
            }
            return numbers[left] ;
    }

}
