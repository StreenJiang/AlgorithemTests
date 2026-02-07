package Strings.Matching;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();

        // 步骤1: 计算最小重复次数 k = ceil(m/n)
        // 公式: (m + n - 1) / n 实现向上取整（避免浮点运算）
        int minRepeat = (m + n - 1) / n;

        // 步骤2: 构造重复 minRepeat 次的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minRepeat; i++) {
            sb.append(a);
        }
        String repeated = sb.toString();

        // 步骤3: 检查 b 是否是 repeated 的子串
        if (repeated.contains(b)) {
            return minRepeat;
        }

        // 步骤4: 再重复一次（处理跨越边界的情况）
        repeated += a;  // 相当于 minRepeat + 1 次
        if (repeated.contains(b)) {
            return minRepeat + 1;
        }

        // 步骤5: 仍不包含 → 不可能
        return -1;
    }
}
