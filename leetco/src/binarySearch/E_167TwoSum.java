package binarySearch;

public class E_167TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(numbers[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }

        for(int i = 0; i < end; i ++){
            int flag = end - i;
            int l = 0;
            int right = flag;
            int temp = target - numbers[flag];
            while(l + 1 < right){
                int mid = l + (right - l) /2;
                if(temp == numbers[mid]){
                    return new int[]{mid + 1, flag + 1};
                }else if(temp < numbers[mid]){
                    right = mid;
                }else{
                    l = mid;
                }
            }
            if(temp == numbers[l]){
                return new int[]{l + 1, flag + 1};
            }else if(temp == numbers[right]){
                return new int[]{end + 1, flag + 1};
            }
        }

        return new int[]{-1, -1};

    }
}
