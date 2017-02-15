import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjtu_yjw on 2017/2/15.
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        PalindromePartitioningII p = new PalindromePartitioningII();
        String s = "aab";
        p.minCut(s);
        List<String> result = new ArrayList<>();
        p.midPalindromeString("abccb", result);
        System.out.println(result);
    }

    public int minCut(String s) {
        return 0;
    }

    public void PalindromeString(String s, List result) {
        int length = s.length();
        if (length == 1) {
            result.add(s);
            return;
        }
        int begin = 0;
        int end = length - 1;
        int mid = (begin + end) / 2;
        String leftString = s.substring(begin, mid + 1);
        String rightString = s.substring(mid + 1, end + 1);
        PalindromeString(leftString, result);
        PalindromeString(rightString, result);
        midPalindromeString(s, result);
    }

    public void midPalindromeString(String s, List result) {
        int times = s.length() % 2 == 0?s.length() / 2 : s.length() /2 +1 ;
        boolean even = s.length() % 2 == 0;
        int left = 0;
        int right;
        List subSList = new ArrayList();
        for (int j = 0; j < s.length() / 2 ; j++) {
            for (int i = 0; i < times; i++) {
                if (even) {
                    left = times - (j + 1) ;
                    right = times + i + 1;
                    String subS = s.substring(left, right);
                    subSList.add(subS);
                }else {
                    left = times - (j+2);
                    right = times + i;
                    String subS = s.substring(left, right);
                    subSList.add(subS);
                }

            }
        }
        System.out.println(subSList);
        for (Object o : subSList) {
            String _s = (String) o;
            if (isPalindromeString(_s)) {
                result.add(_s);
            }
        }
    }

    public boolean isPalindromeString(String s) {
        int length = s.length();
        if (length == 1) {
            return true;
        }
        int s1_left = 0;
        int s1_right = 0;
        int s2_left = 0;
        int s2_right = 0;
        if (length % 2 == 0) {
            s2_left = length / 2;
            s2_right = length - 1;
            s1_left = 0;
            s1_right = s2_left - 1;
        } else {
            s1_left = 0;
            s1_right = length / 2 - 1;
            s2_left = length / 2 + 1;
            s2_right = length - 1;
        }
        String s1 = s.substring(s1_left, s1_right + 1);
        String s2 = s.substring(s2_left, s2_right + 1);
        s2 = new StringBuffer(s2).reverse().toString();
        return s1.equals(s2);
    }
}
