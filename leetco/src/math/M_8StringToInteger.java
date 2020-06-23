package math;

public class M_8StringToInteger {
    public int myAtoi(String str) {
        int start = 0;
        while (start < str.length() && str.charAt(start)==' ') {
            start++;
        }
        if (start >= str.length()) {
            return 0;
        }
        char first = str.charAt(start);
        boolean isPositive = true;
        int num = 0;
        if (first == '-') {
            isPositive = false;
        } else if (first == '+') {
            num = 0;
        } else if (!Character.isDigit(first)) {
            return 0;
        } else if (Character.isDigit(first)) {
            num = first - '0';
        }
        for (int i = start + 1; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                int d = str.charAt(i) - '0';
                //overflow if
                //num * 10 + d > max_val; num*10 > max_val - d; num > (max_val-d)/10
                if (num > (Integer.MAX_VALUE - d) / 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + d;
            }
        }
        return isPositive ? num : -num;
    }
}
