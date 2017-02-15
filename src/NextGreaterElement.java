import sun.plugin.javascript.navig.Array;

import java.util.*;

/**
 * Created by xjtu_yjw on 2017/2/14.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] findNums = {2,4};
        int[] nums = {1,2,3,4};
        int[] result = nextGreaterElement(findNums, nums);
        for (int i : result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}
