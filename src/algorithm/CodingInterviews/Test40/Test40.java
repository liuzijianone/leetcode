package algorithm.CodingInterviews.Test40;

import java.util.*;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/4 21:09
 */
public class Test40 {
    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(getLeastNumbers(nums,5)));

    }

    public static int[] getLeastNumber(int[] arr, int k){
        if (arr.length == 0 || k == 0 ){
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int number : arr) {
            if (queue.size() < k){
                queue.add(number);
            }else if(number < queue.peek()){
                queue.poll();
                queue.add(number);

            }
        }

        int[] array = new int[k];
        int i = 0;
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            array[i++] = (int) iterator.next();
        }

        return array;

    }



    public static int[] getLeastNumbers(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            minHeapInsert(arr,i);
        }
        int size = arr.length - 1;
        swap(arr,0, size);
        size --;

        while (size > arr.length - k -1){
            minHeapify(arr,0, size);
            swap(arr,0, size);
            size --;
        }

        int[] array = Arrays.copyOfRange(arr,arr.length - k,arr.length);

        return array;

    }

    public static void minHeapInsert(int arr[], int index) {
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index,(index - 1) / 2 );
            index = (index - 1) / 2;
        }
    }

    public static void minHeapify(int arr[],int index, int heapSize){
        int left = 2 * index +1;
        while(left < heapSize){
            int minist = left + 1 < heapSize && arr[left + 1] < arr[left] ? left +1 : left;
            minist = arr[index] < arr[minist] ? index : minist;
            if (minist == index){
                break;
            }
            swap(arr, index,minist);
            index = minist;
            left = 2 * index +1;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
