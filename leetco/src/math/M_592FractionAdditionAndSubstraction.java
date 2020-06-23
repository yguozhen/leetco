package math;

import java.util.ArrayList;

public class M_592FractionAdditionAndSubstraction {
    public ArrayList<Integer> toArray(String expression){
        ArrayList<Integer> array = new ArrayList<>();
        int flag = 0;
        for(int i = 0; i < expression.length(); i ++){
            char t = expression.charAt(i);
            if(t == '-'){
                flag = 1;
            }
            else if(t <= '9' && t >= '0'){
                int temp = t - '0';
                while(i < expression.length() - 1 && expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9'){
                    temp = (expression.charAt(i + 1) - '0') + temp*10;
                    i++;
                }
                if(flag == 1){
                    array.add(0 - temp);
                    flag = 0;
                }else{
                    array.add(temp);
                }
            }else if(t == '/'){
                continue;
            }


        }
        return array;
    }
    private static int gcd(int a, int b) {
        return b==0? a: gcd(b,a%b);
    }
    public String fractionAddition(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        ArrayList<Integer> array = new ArrayList<>();
        array = toArray(expression);
        int[] result = new int[2];
        result[0] = array.get(0);
        result[1] = array.get(1);
        int flag = 0;
        for(int i = 2; i < array.size();i = i + 2){
            int a = result[0];
            int b = result[1];
            int c = array.get(i);
            int d = array.get(i + 1);
            int numerater = a * d + b * c;
            int denominator = b * d;
            if(numerater < 0){
                flag = 1;
                numerater = Math.abs(numerater);

            }
            int gcd = gcd(numerater, denominator);
            numerater /= gcd;
            denominator /= gcd;
            if(flag == 1){
                numerater = 0 - numerater;
                flag = 0;
            }
            result[0] = numerater;
            result[1] = denominator;
        }

        return Integer.toString(result[0]) + '/' + Integer.toString(result[1]);
    }
}
