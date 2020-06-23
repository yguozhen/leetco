package math;

public class M_573SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int minvalue = Integer.MAX_VALUE;
        int[][] nutsvalue = new int[nuts.length][2];
        int res = 0;
        for(int i = 0; i < nuts.length; i ++){
            int temp = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
            int distance = Math.abs(squirrel[0] - nuts[i][0])  + Math.abs(squirrel[1] - nuts[i][1]);
            int compare = distance - temp;

            if(compare < minvalue){
                minvalue = compare;
            }
            res = res + temp * 2;
        }


        return  res + minvalue;
    }
}
