import java.util.ArrayList;

public class main {
    public static void main(String args[]){

        int[][] points = {{-7,8}, {-4,6}, {2,6}, {6,4}, {8,6}, {7,-2}, {4,-6},
                {8,-7},{0,0}, {3,-2},{6,-10},{0,-6},{-9,-5},{-8,-2},{-8,0},{-10,3},{-2,2},{-10,4}};

        int[][] hull = ConvexHull.findConvexHull(points);
        for (int[] i : hull){
            for (int j : i)
                System.out.printf("%d ",j);
            System.out.println("");
        }
    }
}
