package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class ArrayIsPossible {
    public boolean isPossible(int[] target) {
        int n = target.length;

        // 特判1：单元素数组
        // [1] 可行（初始状态），[2]/[5] 等均不可行（无法改变）
        if (n == 1) {
            return target[0] == 1;
        }

        // 使用最大堆快速获取当前最大值
        // 注意：用 Long 避免大数溢出（题目约束：元素可达 10^9，总和可能超 int）
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;  // 当前数组总和（用 long 防溢出）

        // 初始化：将所有元素加入堆，并计算总和
        for (int num : target) {
            maxHeap.offer((long) num);
            total += num;
        }

        // 逆向推导：直到所有元素变为 1
        while (true) {
            // 1. 取出当前最大值
            long maxVal = maxHeap.poll();

            // 2. 终止条件：最大值为 1 → 所有元素都是 1（已回到起始状态）
            if (maxVal == 1) {
                return true;
            }

            // 3. 计算其他元素之和
            long rest = total - maxVal;

            // 4. 边界检查（不可行情况）
            //    a) rest == 0：理论上不会出现（n≥2 时 rest ≥ 1）
            //    b) rest >= maxVal：最大值不大于其他元素之和
            //       → 无法由"替换总和"操作产生（替换后该元素应 > 其他所有元素之和）
            if (rest == 0 || rest >= maxVal) {
                return false;
            }

            // 5. 计算上一步该位置的值（关键优化：取模代替多次减法）
            long prev = maxVal % rest;

            // 6. 特殊处理：取模结果为 0 时，应设为 rest（保证值 ≥ 1）
            //    例如 [1, 100]：100 % 1 = 0，但上一步应是 1（不是 0）
            if (prev == 0) {
                prev = rest;
            }

            // 7. 更新总和：移除 maxVal，加入 prev
            total = total - maxVal + prev;

            // 8. 将上一步的值放回堆中
            maxHeap.offer(prev);

            // 循环继续，直到所有元素变为 1 或判定不可行
        }
    }
}
