class Solution {
    int transform(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        if(n!=m){
            return -1;
            
        }
        int freq[]=new int[256];
        for(int i=0;i<n;i++){
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(freq[i]!=0){
                return -1;
            }
            
        }
        //finding the longest suffix 
        int i=n-1;int j=n-1;
        int count=0;
        while(i>=0 && j>=0){
            if(s1.charAt(i)==s2.charAt(j)){
                i--;
                j--;
                
            }
            else{
               i--;
               count++;
            }
        }
        return count;
    }
}