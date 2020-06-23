package math;

public class E_492ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        if(area == 0){
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        for(int i = 1; i * i <= area; i ++){
            if(area % i != 0){
                continue;
            }
            res[0] = area / i;
            res[1] = i;
        }
        return res;
    }
}
