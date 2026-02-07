package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    // 自定义类：封装一对索引及其对应的和
    static class Pair {
        int index1;  // nums1 的索引
        int index2;  // nums2 的索引
        int sum;     // nums1[index1] + nums2[index2]

        public Pair(int index1, int index2, int[] nums1, int[] nums2) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = nums1[index1] + nums2[index2];
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界检查
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        // 创建最小堆：按 sum 升序排列
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.sum));

        // 初始化：将 (i, 0) 加入堆
        int initSize = Math.min(k, nums1.length);
        for (int i = 0; i < initSize; i++) {
            minHeap.offer(new Pair(i, 0, nums1, nums2));
        }

        // 取出 k 个最小和的 pair
        while (k > 0 && !minHeap.isEmpty()) {
            Pair current = minHeap.poll();

            // 添加结果
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[current.index1]);
            pair.add(nums2[current.index2]);
            result.add(pair);

            // 加入下一个候选 (i, j+1)
            if (current.index2 + 1 < nums2.length) {
                minHeap.offer(new Pair(current.index1, current.index2 + 1, nums1, nums2));
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 5, 6};
        int[] nums2 = new int[] {1, 2, 14};
        int k = 3;

        List<List<Integer>> lists = new KSmallestPairs().kSmallestPairs(nums1, nums2, k);
        System.out.println(lists);
    }
}
