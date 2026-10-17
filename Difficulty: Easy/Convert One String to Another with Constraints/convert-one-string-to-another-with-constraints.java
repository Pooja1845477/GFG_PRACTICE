class Solution {
    public boolean isItPossible(String s1, String s2) {
        // code here
        int n=s1.length();
        if(n!=s2.length()){
            return false;
        }
        int i=0,j=0;
        while(i<n && j<n){
            while(i<n && s1.charAt(i)=='#'){
                i++;
                }
            while(j<n && s2.charAt(j)=='#'){
                j++;
        }
       if(i==n || j==n){
           return i==n && j==n;
       } 
       if(s1.charAt(i)!=s2.charAt(j)){
           return false;
       }
       //A can move towards left
       if(s1.charAt(i)=='A'&&i<j){
           return false;
           
       }
       //B can move only towards the right.
       if(s2.charAt(j)=='B'&& i>j){
           return false;
       }
       i++;
       j++;
    }
    return true;
    }
    
};
