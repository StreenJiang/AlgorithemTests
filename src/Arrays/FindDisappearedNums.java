package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 第一遍：标记出现过的数字
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);      // 获取原始值
            int index = num - 1;              // 对应下标
            if (nums[index] > 0) {
                nums[index] = -nums[index];   // 标记为负
            }
        }

        // 第二遍：找出未被标记的位置
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);            // i+1 是缺失的数字
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = new FindDisappearedNums().
                findDisappearedNumbers(new int[]{5, 1, 3, 4, 7, 5, 1, 3});

        disappearedNumbers.forEach(System.out::print);
    }
}
