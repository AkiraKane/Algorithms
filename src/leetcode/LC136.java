package leetcode;

public class LC136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) res ^= num;
        return res;
    }
}