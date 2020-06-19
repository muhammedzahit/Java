import java.util.Stack;

public class ConvexHull {
    public static double angle(double x1,double y1,double x2,double y2){
        if (x1 == x2) return 90;
        double a = Math.atan((y2-y1)/(x2-x1));
        if (a < 0){
            return 180 + a;
        }
        return a;
    }
    public static void swap(int[][] points,int a,int b){
        int[] temp = new int[2];
        for (int k=0; k<2; k++)
            temp[k] = points[a][k];
        points[a] = points[b];
        points[b] = temp;
    }
    public static void ySort(int[][] points){
        int size = points.length;
        int h = 1;
        while (h < size/3) h = h*3+1;
        while (h > 0){
            for (int i=h; i<size; i++){
                for (int j=i; j>=h && points[j][1] < points[j-h][1] ; j -= h){
                    swap(points,j,j-h);
                }
            }
            h /= 3;
        }
    }
    public static void angleSort(int[][] points){
        int size = points.length;
        int x1 = points[0][0];
        int y1 = points[0][1];
        for (int i=1; i<size-1 ;i++){
            int min = i;
            int x3 = points[min][0];
            int y3 = points[min][1];
            for (int j=i+1; j<size; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (angle(x1,y1,x2,y2) < angle(x1,y1,x3,y3)){
                    min = j;
                    x3 = x2;
                    y3 = y2;
                }
            }
            swap(points,min,i);
        }
    }
    public static int donusKontrol(int[] p1,int[] p2,int[] p3){
        double a = (p2[0]-p1[0])*(p3[1]-p1[1]);
        double c = (p2[1]-p1[1])*(p3[0]-p1[0]);
        double b = a - c;
        if (b > 0) return 1;
        else if (b == 0) return 0;
        return -1;
    }
    public static int[][] findConvexHull(int[][] points){
        Stack<Integer> st = new Stack<Integer>();
        ySort(points);
        angleSort(points);
        int size = points.length;
        st.push(0);
        st.push(1);
        for (int i=2; i<size; i++){
            int x = st.pop();
            int y = st.pop();
            st.push(y);st.push(x);
            if (donusKontrol(points[y],points[x],points[i]) == 1){
                st.push(i);
            }
            else{
                st.pop();
                if (st.size() == 1) st.add(i);
                else i--;
            }
        }
        int[][] hull = new int[st.size()][2];
        int k = 0;
        for (int i : st){
            hull[k][0] = points[i][0];
            hull[k++][1] = points[i][1];
        }
        return hull;
    }
}
