package Strings.Matching;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}
