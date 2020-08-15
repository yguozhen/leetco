package Array;

public class E_1295FindNumbersWithEvenNumbersOfDigit {
    //solution1 brute
    public int findNumbers1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        for(int num : nums){
            int count = 1;
            while(num / 10 != 0){
                count++;
                num = num/10;
            }
            if(count % 2 == 0){
                result++;
            }

        }
        return result;
    }

    //solution2 change int to string
    public int findNumbers2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        for(int num : nums){
            if(Integer.toString(num).length()% 2 == 0){
                result++;
            }
        }
        return result;
    }
}
