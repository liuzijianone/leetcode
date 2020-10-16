package algorithm.others.advanced.Lesson01;

import java.util.Arrays;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/14 14:23
 */
public class ManacherDemo {
    public static void main(String[] args) {
        String str = "cbba";
        System.out.println(maxLcpsLength(str));
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

    public static String maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String s = str;

        str = getManacherString(str);
        char[] array = str.toCharArray();
        int[] P = new int[array.length];

        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

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
            if(max < P[i]){
                max = P[i];
                maxIndex = i;
            }
        }
        return s.substring((maxIndex - P[maxIndex] + 1) / 2, (maxIndex - P[maxIndex] + 1) / 2 + max - 1);

    }

}
