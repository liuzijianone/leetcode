package algorithm.others.advanced.Lesson01;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/29 10:58
 */
public class KMPDemo {

    public static void main(String[] args) {
        String str = "aabaaabaaac";
        String match ="aabaaac";
        System.out.println(getIndexOf(str, match));

    }

    public static int getIndexOf(String str, String match){
        if(str == null || match == null || match.length() == 0 || str.length() < match.length()){
            return -1;
        }
        int[] next = getNextArray(match);

        char[] strArray = str.toCharArray();
        char[] matchArray = match.toCharArray();

        int strIndex = 0;
        int matchIndex = 0;

        while (strIndex < strArray.length && matchIndex < matchArray.length){
            if(strArray[strIndex] == matchArray[matchIndex]){
                strIndex++;
                matchIndex++;
            }else if(matchIndex == 0){
                strIndex++;
            }else{
                matchIndex = next[matchIndex];
            }
        }
        if (matchIndex == matchArray.length){
            return strIndex - matchIndex;
        }else{
            return -1;
        }
    }

    private static int[] getNextArray(String match) {
        if(match.length() == 1){
            return new int[]{-1};
        }

        char[] array = match.toCharArray();

        int next[] = new int[match.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while( i < next.length){
            if(array[i - 1] == array[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }

        return next;
    }
}
