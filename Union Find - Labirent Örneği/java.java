import java.util.Scanner;

public class java {

    public static void main(String[] args) {
        /*
        Bu algoritma girilen labirentte yukarıdan aşağıya bir çıkış yolu olup olmadığını bulur.
        Union-Find algoritması kullanılmıştır.
        */
        UF uf = new UF();
        int [][] grid = {
                {0,1,1,1,1},
                {0,0,1,1,1},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0}
        };
        System.out.println(uf.is_there_a_way(grid));
    }

}
