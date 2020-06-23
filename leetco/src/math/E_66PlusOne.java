package math;

public class E_66PlusOne {

    //solution1
    public int[] plusOne(int[] digits) {
             if (digits == null || digits.length == 0) return digits;
             for (int i = digits.length - 1; i >= 0; i--) {
                 if (digits[i] < 9) {
                     digits[i]++;
                     return digits;
                 } else {
                     digits[i] = 0;
                 }
             }
             int[] res = new int[digits.length + 1];
             res[0] = 1;
             return res;
         }

         //solution2
        public int[] plusOne2(int[] digits) {
            if(digits == null ){
                return new int[]{};
            }
            if(digits == null){
                return new int[]{1};
            }

            if(digits[digits.length - 1] < 9){
                digits[digits.length - 1] = digits[digits.length - 1] + 1;
                return digits;
            }
            int flag =0;
            int[] result = new int[digits.length];
            for(int i = digits.length - 1; i >= 0; i --){
                if(digits[i] == 9 && flag == 0){
                    result[i] = 0;

                }else if(digits[i] != 9 && flag == 0){
                    flag = 1;
                    result[i] = digits[i] + 1;

                }else{
                    result[i] = digits[i];
                }
            }
            if(digits[0] == 9 && flag == 0){
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                System.arraycopy(result, 0, res, 1, res.length - 1);
                return res;
            }else{
                return result;
            }


        }
}
