//https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public String intToRoman(int num) {
        String result = "";
        String numString = String.valueOf(num);
        int pos = numString.length() - 1;
        for (int i = 0; i < numString.length(); i++) {
            int c = (int) Character.getNumericValue(numString.charAt(i));
            if (pos == 3) {
                for (int j = 0; j < c; j++) result += "M";
            } else if (pos == 2) {
                result += romaniser(c, "C", "D", "M");
            } else if (pos == 1) {
                result += romaniser(c, "X", "L", "C");
            } else {
                result += romaniser(c, "I", "V", "X");
            }
            pos--;
        }
        return result;
    }
    public String romaniser(int num, String small, String big, String biggest) {
        if (num == 0) return "";
        else if (num >= 1 && num <= 3) {
            String miniString = "";
            for (int j = 0; j < num; j++) miniString += small;
            return miniString;
        } else if (num == 4) {
            return "" + small + big;
        } else if (num == 5) {
            return big;
        } else if (num >=6 && num <= 8) {
            String miniString = big;
            for (int j = 0; j < num - 5; j++) miniString += small;
            return miniString;
        } else {
            return "" + small + biggest;
        }
    }
}
