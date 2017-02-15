/**
 * Created by xjtu_yjw on 2017/2/14.
 */
public class HammingDistance {

    public static void main(String[] args) {
        int r = hammingDistance(255, 0);
        System.out.println(r);
        System.out.println(Integer.bitCount(1 ^ 5));

    }

    public static int hammingDistance(int x, int y) {
        if (y < x) {
            int t = y;
            y = x;
            x = t;
        }
        int distance = 0;
        while (y / 2 != 0  || y == 1) {
            if (x % 2 != y % 2) {
                distance++;
            }
            y = y / 2;
            x = x / 2;
        }

        return distance;

    }
}
