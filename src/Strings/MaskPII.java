package Strings;

public class MaskPII {
    public String maskPII(String s) {
        String result;

        if (s.contains("@")) {
            result = handleEmail(s);
        } else {
            result = handlePhoneNum(s);
        }

        return result;
    }

    private String handlePhoneNum(String s) {
        StringBuilder resultTemp = new StringBuilder();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                if (count == 4) {
                    resultTemp.append("-");
                } else if (count > 4 && (count - 4) % 3 == 0) {
                    resultTemp.append("-");
                }

                if (count >= 4) {
                    resultTemp.append("*");
                } else {
                    resultTemp.append(s.charAt(i));
                }

                count++;
            }
        }

        if (count - 10 > 0) {
            resultTemp.append("+");
        }

        return resultTemp.reverse().toString();
    }

    private String handleEmail(String s) {
        String[] split = s.toLowerCase().split("@");
        StringBuilder resultTemp = new StringBuilder();

        String name = split[0];

        resultTemp.append(name.charAt(0));
        resultTemp.append("*****");
        resultTemp.append(name.charAt(name.length() - 1));
        resultTemp.append("@");
        resultTemp.append(split[1]);

        return resultTemp.toString();
    }
}
