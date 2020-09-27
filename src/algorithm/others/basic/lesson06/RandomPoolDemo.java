package algorithm.others.basic.lesson06;

import java.util.HashMap;
import java.util.Random;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/17 9:37
 */
public class RandomPoolDemo {
    public static void main(String[] args) {
            RandomPool pool = new RandomPool();
            pool.insert("zuo");
            pool.insert("cheng");
            pool.insert("yun");
            pool.remove("zuo");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());

            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());

    }

}

class RandomPool{
    private HashMap<Integer, String> map1;
    private HashMap<String, Integer> map2;

    public  RandomPool() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void insert(String str){
        map1.put(map1.size(),str);
        map2.put(str, map2.size());
    }

    public String getRandom(){
        if (map1.size() == 0){
            return null;
        }
        int index = new Random().nextInt(map1.size());
        return map1.get(index);
    }

    public void remove(String str){
        if (!map2.containsKey(str)) {
            return;
        }
        int index = map2.get(str);
        String lastStr = map1.get(map1.size() - 1);
        map1.put(index, lastStr);
        map2.put(lastStr, index);
        map1.remove(map1.size() - 1);
        map2.remove(str);

    }
}
