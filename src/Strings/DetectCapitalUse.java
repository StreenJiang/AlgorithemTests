package Strings;

public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)  return true;

        boolean firstUpper = Character.isUpperCase(word.charAt(0));
        boolean secondUpper = Character.isUpperCase(word.charAt(1));

        if (firstUpper && secondUpper) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) return false;
            }
            return true;
        }

        if (firstUpper && !secondUpper) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        }

        if (!firstUpper){
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        }

        return false;
    }

    static void main() {
        String word = "USA";
        boolean result = new DetectCapitalUse().detectCapitalUse(word);

        System.out.println(result);
    }
}
