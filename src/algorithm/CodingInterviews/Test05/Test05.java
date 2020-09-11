package algorithm.CodingInterviews.Test05;

import org.junit.Test;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/30 20:34
 *
 * 考虑String由char[]实现，是不可变的对象
 * 使用StringBuilder更有利于降低内存和时间的使用
 */
public class Test05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(s.replaceAll(" ","%20"));
    }

    @Test
    public void test01(){
        String s = "We are happy.";
        StringBuilder builder = new StringBuilder();
        for (int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if (' ' == c){
                builder.append("%20");
            }else{
                builder.append(c);
            }
        }
        System.out.println(builder.toString());
    }

}
