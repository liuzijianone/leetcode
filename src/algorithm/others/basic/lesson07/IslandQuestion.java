package algorithm.others.basic.lesson07;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/20 9:11
 */
public class IslandQuestion {
    public static void main(String[] args) {
        int[][] array = {{0,0,1,0,1,0},{1,1,1,0,1,0},{1,0,0,1,0,0},{0,0,0,0,0,0}};
        System.out.println(countIsland(array));

    }

    public static int countIsland(int[][] array){
        int M = array.length - 1;
        int N = array[0].length - 1;

        if (M == -1 || N == -1){
            return -1;
        }

        int res = 0;
        for (int i = 0; i <= M; i++) {
            for(int j = 0; j <= N; j++){
                if (array[i][j] == 1){
                    infect(i, j, M, N, array);
                    res++;
                }
            }
        }
        return res;
    }

    private static void infect(int i, int j, int m, int n, int[][] array) {
        if (i < 0 || i > m || j < 0 || j > n || array[i][j] != 1 ){
            return;
        }
        array[i][j] = 2;
        infect(i - 1, j, m, n, array);
        infect(i + 1, j, m, n, array);
        infect(i, j - 1, m, n, array);
        infect(i, j + 1, m, n, array);
    }
}
