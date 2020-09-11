package algorithm.CodingInterviews.Test03;

import sun.awt.windows.WPrinterJob;

import java.lang.reflect.Array;

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

class student<T>{
    private int ga;
    private T age;

}

