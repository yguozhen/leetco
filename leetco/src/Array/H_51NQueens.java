package Array;

import java.util.ArrayList;
import java.util.List;

public class H_51NQueens {

    //solution1 recursive O(n!)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        search(result, new ArrayList<Integer>(), n);
        return result;
    }

    private void search(List<List<String>> result, List<Integer> list, int n){
        if(list.size() == n){
            result.add(formal(list));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!isValid(list, i)){
                continue;
            }
            list.add(i);
            search(result, list, n);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(List<Integer> list, int n){
        int row = list.size();
        for(int i = 0; i < row; i++){
            if(list.get(i) == n){
                return false;
            }
            //think about the slope
            if(row + n == i + list.get(i)){
                return false;
            }
            if(row - n == i - list.get(i)){
                return false;
            }
        }
        return true;
    }

    private List<String> formal(List<Integer> list){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++){
                sb.append(list.get(i) == j ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;

    }
}
