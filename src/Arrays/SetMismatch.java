package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        Set<Integer> setAll = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            setAll.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            int currIndex = i + 1;
            if (!setAll.contains(currIndex)) {
                result[1] = currIndex;
            }
            if (!set.add(currVal)) {
                result[0] = currVal;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new SetMismatch().findErrorNums(new int[] {1, 2, 2, 4});
    }
}
