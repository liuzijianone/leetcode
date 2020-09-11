package algorithm.CodingInterviews.Test11;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/3 20:18
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
