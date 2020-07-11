package math;

public class E_415AddStrings {
    //solution1
    public String addStrings1(String num1, String num2) {
        int max = Math.max(num1.length(), num2.length());
        StringBuilder res = new StringBuilder();
        int remainder = 0;
        int divisor = 0;
        int n1 = 0, n2 = 0;
        for(int i = 0; i < max; i ++){
            if(i < num1.length() && i< num2.length()){
                n1 = num1.charAt(num1.length() - i - 1) - '0';
                n2 = num2.charAt(num2.length() - i - 1) - '0';
            }else if(i < num1.length() && i >= num2.length()){
                n1 = num1.charAt(num1.length() - i - 1) - '0';
                n2 = 0;
            }else if(i < num2.length() && i >= num1.length()){
                n1 = 0;
                n2 = num2.charAt(num2.length() - i - 1) - '0';
            }
            int number = n1 + n2 + divisor;
            divisor = number / 10;
            remainder = number % 10;
            res.append(remainder);
        }
        if(divisor != 0){
            res.append(divisor);
        }
        res.reverse();
        return res.toString();

    }

    //solution2 cspiration
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >=0 || j >= 0 || carry == 1){
            int a = i >= 0 ? num1.charAt(i--) - '0':0;
            int b = j >= 0 ? num2.charAt(j--) - '0':0;
            int number = a + b + carry;
            res.append(number % 10);
            carry = number / 10;
        }
        return res.reverse().toString();
    }
}
