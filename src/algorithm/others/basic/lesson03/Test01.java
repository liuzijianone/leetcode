package algorithm.others.basic.lesson03;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/8 15:11
 *  使用数组实现队列和栈
 */
public class Test01 {
}

class ArrayStack{
    private int index;
    private int[] nums;

    public ArrayStack() {
        this.nums = new int[10];
    }

    public Integer peek(){
        if (index == 0){
            return null;
        }
        return nums[index - 1];
    }

    public void push(Integer x){
        if (index == nums.length){
            throw new ArrayIndexOutOfBoundsException("stack is full");
        }
        nums[index++] = x;
    }

    public Integer pop(){
        if (index == 0){
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        return nums[--index];
    }
}

class ArrayQueue{
    private int[] nums;
    private int start;
    private int end;
    private int size;

    public ArrayQueue() {
        this.nums = new int[10];
    }

    public Integer peek(){
        if (size == 0){
            return  null;
        }
        return nums[start];
    }

    public void push(Integer x){
        if (size == nums.length){
            throw  new ArrayIndexOutOfBoundsException("queue is full");
        }
        nums[end] = x;
        end = (end + 1) % nums.length;
        size++;
    }

    public Integer pop(){
        if (size == 0){
            throw  new ArrayIndexOutOfBoundsException("queue is empty");
        }
        Integer y = nums[start];
        start = (start + 1) %nums.length;
        size --;
        return y;
    }

}
