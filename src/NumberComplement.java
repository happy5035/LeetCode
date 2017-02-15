import java.util.stream.Stream;

/**
 * Created by xjtu_yjw on 2017/2/14.
 */
public class NumberComplement {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(findComplement(1));
        System.out.println(Integer.highestOneBit(16));
        System.out.println(Integer.toBinaryString(~5));
    }

    public static int findComplement(int num) {
        String bS = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        char[] bSs = bS.toCharArray();
        for (char s : bSs) {
            if (s == '0') {
                sb.append('1');
            } else {

                sb.append('0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
