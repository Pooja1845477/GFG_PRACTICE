class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length;
        int plat=1;
        int ans=1;
        int i=1,j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat++;
                ans=Math.max(ans,plat);
                i++;
                
            }
            else{
                plat--;
                j++;
            }
        }
        return ans;
    }
}
