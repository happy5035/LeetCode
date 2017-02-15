import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by xjtu_yjw on 2017/2/14.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.asList(findWords(words)));
        System.out.println(Arrays.asList(
                Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new)));
        System.out.println(Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")));
        System.out.println("aaa".matches("a*"));
    }

    public static String[] findWords(String[] words) {
        char[][] r1 = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'},};
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < r1.length; i++) {
            char[] _r = r1[i];
            for (char c : _r) {
                map.put(c, i);
            }
        }
        List<String> lists = new ArrayList<String >();
        for (String word : words) {
            char[] word_chars = word.toLowerCase().toCharArray();
            int row = -1;
            boolean inRow = true;
            for (char word_char : word_chars) {
                if (row == -1) {
                    row = map.get(word_char);
                } else {
                    int _row = map.get(word_char);
                    if (_row != row) {
                        inRow = false;
                        break;
                    }
                }

            }
            if (inRow) {
                lists.add(word);
            }
        }
        return lists.toArray(new String[0]);
    }
}
