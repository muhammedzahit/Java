public class UF {
    public int[] parent;
    public int find(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean check(int r,int c,int n){
        return (r > -1 && r < n && c > -1 && c < n);
    }
    public boolean is_there_a_way(int[][] grid) {
        int n = grid.length;
        parent = new int[(n*n)+2];
        for (int i=0; i<(n*n)+2; i++) parent[i] = i;
        for (int i=0; i<n; i++){
            if (grid[0][i] == 1) parent[i+1] = 0;
            if (grid[n-1][i] == 1) parent[(n*n)-i] = (n*n)+1;
        }
        for (int i=1; i<n-1; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    if (check(i+1,j,n) && grid[i+1][j] == 1){
                        parent[find((i+1)*n+(j)+1)] = parent[find(i*n+j+1)];
                    }
                    if (check(i,j+1,n) && grid[i][j+1] == 1){
                        parent[find((i)*n+(j+1)+1)] = parent[find(i*n+j+1)];
                    }
                    if (check(i-1,j,n) && grid[i-1][j] == 1){
                        parent[find((i-1)*n+(j)+1)] = parent[find(i*n+j+1)];
                    }
                    if (check(i,j-1,n) && grid[i][j-1] == 1){
                        parent[find((i)*n+(j-1)+1)] = parent[find(i*n+j+1)];
                    }
                }
            }
        }
        return find(0) == find(n*n+1);
    }
}
