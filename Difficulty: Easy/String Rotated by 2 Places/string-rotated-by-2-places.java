class Solution {
    public static boolean isRotated(String s1, String s2) {
        // code here
        int n=s1.length();
        if(n!=s2.length()){
            return false;
        }
        if(n<=2){
            return s1.equals(s2);
        }
        //left rotation by 2
        String left=s1.substring(2)+s1.substring(0,2);
        String right=s1.substring(n-2)+s1.substring(0,n-2);
        return s2.equals(left) || s2.equals(right);
    }
}