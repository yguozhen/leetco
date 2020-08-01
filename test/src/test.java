import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(2);
        test.add(9);
        test.add(4);
        test = mergeSort1(test);
        for(int num : test){
            System.out.println(num);
        }
    }
    //merge sort1
    public static ArrayList<Integer> mergeSort1(ArrayList<Integer> array){
        if(array == null || array.size() <= 1){
            return array;
        }
        return mergeSort1(array, 0, array.size() - 1);
    }
    public static ArrayList<Integer> mergeSort1(ArrayList<Integer> array, int start, int end){
        ArrayList<Integer> result = new ArrayList<>();
        if(start > end){
            return result;
        }
        if(start == end){
            result.add(array.get(start));
            return result;
        }
        int mid = start + (end - start)/2;
        ArrayList<Integer> left = mergeSort1(array, start, mid);
        ArrayList<Integer> right = mergeSort1(array, mid + 1, end);
        merge(left, right, result);
        return result;
    }
    private static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> result){
        int i = 0;
        int j = 0;
        while(i < left.size() && j < right.size()){
            if(left.get(i) < right.get(j)){
                result.add(left.get(i++));
            }else{
                result.add(right.get(j++));
            }
        }
        while(i <= left.size() - 1){
            result.add(left.get(i++));
        }
        while(j <= left.size() - 1){
            result.add(right.get(j++));
        }
    }
}
