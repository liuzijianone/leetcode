package algorithm.others.sort;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/7 16:09
 * <p>
 * 堆排序的细节和复杂度分析
 * 时间复杂度O(N*logN)，额外空间复杂度O(1)
 * 堆结构非常重要
 * 1，堆结构的heapInsert与heapify
 * 2，堆结构的增大和减少
 * 3，如果只是建立堆的过程，时间复杂度为O(N)
 * 4，优先级队列结构，就是堆结构
 */
public class heapSort {
    public static void main(String[] args) {
        int[] array = {4, 7, 8, 5, 9, 10, 20, 15, 6};
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void heapSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            maxheapInsert(array, i);
//            minHeapInsert(array, i);
        }

        int heapSize = array.length;
        swap(array, 0, --heapSize);
        while (heapSize > 0){
            maxheapify(array, 0, heapSize);
//            minheapify(array, 0, heapSize);
            swap(array,0, --heapSize);
        }


    }

    // 调整大顶堆
    public static void maxheapify(int[] array, int index, int heapSize){
        int left = 2 * index + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(array, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }


    public static void minheapify(int[] array, int index, int heapSize){
        int left = 2 * index + 1;
        while (left < heapSize){
            int minist = left + 1 < heapSize && array[left + 1] < array[left] ? left + 1 : left;
            minist = array[minist] < array[index] ? minist : index;
            if (minist == index){
                break;
            }
            swap(array, index, minist);
            index = minist;
            left = 2 * index + 1;
        }
    }

    // 构建大顶堆
    public static void maxheapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void minHeapInsert(int[] array, int index) {
        while (array[index] <array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
