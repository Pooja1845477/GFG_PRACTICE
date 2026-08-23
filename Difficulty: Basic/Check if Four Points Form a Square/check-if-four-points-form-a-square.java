class Solution {
   
        // code here
        int dist(int[] p1,int[] p2){
            int dx=p1[0]-p2[0];
            int dy=p1[1]-p2[1];
            return dx*dx+dy*dy;
        }
         boolean isSquare(int points[][]) {
             int d[]=new int[6];
             int k=0;
             //calculating distance between every pair
             for(int i=0;i<4;i++){
                 for(int j=i+1;j<4;j++){
                     d[k++]=dist(points[i],points[j]);
                 }
             }
             //sort the distances
             java.util.Arrays.sort(d);
             //four equal non zero sides
             if(d[0]==0)
             return false;
             if(d[0]!=d[1]||
             d[1]!=d[2]||
             d[2]!=d[3])
             return false;
             //checking diagonals are equal or not
             if(d[4]!=d[5])
             return false;
             // Diagonal²=2×Side²
             return d[4]==2*d[0];
    }
}