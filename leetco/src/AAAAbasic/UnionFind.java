package AAAAbasic;

public class UnionFind {
    private int[] father = null;
    public int find(int x){
        if(father[x] == x){
            return x;
        }
        return find(father[x]);
    }

    public void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
        }
    }
}
