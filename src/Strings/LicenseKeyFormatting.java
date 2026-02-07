package Strings;

import java.util.Arrays;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        String str = s.replaceAll("-", "").toUpperCase();

        if (str.isEmpty()) {
            return "";
        }

        StringBuilder resultTemp = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (count == k) {
                count = 0;
                resultTemp.append("-");
            }

            resultTemp.append(str.charAt(i));
            count++;
        }

        return resultTemp.reverse().toString();
    }
}
