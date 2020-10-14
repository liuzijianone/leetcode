package algorithm.others.advanced.Lesson01;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/14 14:23
 */
public class ManacherDemo {
    public static void main(String[] args) {
        String str = "12343";
        System.out.println(maxLcpsLength(str));
//        System.out.println(getManacherString(str));
    }

    public static String getManacherString(String str){
        StringBuilder builder = new StringBuilder();
        for (int  i = 0; i < str.length(); i++){
            builder.append('#');
            builder.append(str.charAt(i));
        }
        builder.append('#');
        return builder.toString();
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = getManacherString(str);
        char[] array = str.toCharArray();
        int[] P = new int[array.length];

        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            P[i] = R > i ? Math.min(P[2 * C - i], R - i) : 1;
            while (i - P[i] >= 0 && i + P[i] < array.length) {
                if (array[i - P[i]] == array[i + P[i]]) {
                    P[i]++;
                } else {
                    break;
                }
            }

            if (i + P[i] > R) {
                C = i;
                R = P[i] + i;
            }
            max = Math.max(max, P[i]);
        }

        System.out.println(Arrays.toString(P));
        return max - 1;
    }

}
