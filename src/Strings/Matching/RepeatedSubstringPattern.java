package Strings.Matching;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }

        return checkRepeated(1, s);
    }

    private boolean checkRepeated(int count, String s) {
        if (s.length() % count > 0) {
            return checkRepeated(count + 1, s);
        } else if (count * 2 > s.length()) {
            return false;
        }

        boolean OK = true;

        int currIndex = count;
        while (currIndex + count <= s.length()) {
            String current = s.substring(0, count);
            String next = s.substring(currIndex, currIndex + count);
            if (current.equals(next)) {
                currIndex += count;
            } else {
                OK = false;
                break;
            }
        }

        if (!OK) {
            return checkRepeated(count + 1, s);
        }
        return true;
    }

    static void main() {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abaababaab"));
    }
}
