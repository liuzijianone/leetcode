package algorithm.others.basic.lesson07;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/20 9:31
 */
public class TrieTree {
    private static TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word){
        if (word == null){
            return;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < array.length; i++) {
            int index = (int)array[i]- 'a';
            if (node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path ++;
        }
        node.end ++;
    }

    public int search(String word){
        if (word == null){
            return -1;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < array.length ; i++){
            int index = (int)array[i] - 'a';
            if (node.nexts[index] == null){
                return -1;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public void delete(String word){
        if (word == null){
            return;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < array.length ; i++){
            int index = (int)array[i] - 'a';
            if (--node.path == 0 || node.nexts[index] == null){
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    public int searchPrefix(String word){
        if (word == null){
            return -1;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < array.length; i++) {
            int index = (int)array[i]- 'a';
            if (node.nexts[index] == null){
               return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }

}

class TrieNode{
    int path;
    int end;
    TrieNode[] nexts;

    public TrieNode() {
        this.path = 0;
        this.end = 0;
        this.nexts = new TrieNode[26];
    }
}
