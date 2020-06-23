package math;

public class E_504Base7 {
    //solution1 int[]
    public String convertToBase7(int num) {
        int reminder = num % 7;
        int divisor = num / 7;
        int temp = 0;
        int level = 0;
        while(reminder != 0 || divisor != 0){
            temp = temp + reminder * (int)Math.pow(10, level);
            reminder = divisor % 7;
            divisor = divisor / 7;
            level ++;

        }
        return temp + "";
    }
    //solution2 reverse
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0){
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }
        if (negative) {
            sb.append("-");
        }
        //
        return sb.reverse().toString();
    }
}
