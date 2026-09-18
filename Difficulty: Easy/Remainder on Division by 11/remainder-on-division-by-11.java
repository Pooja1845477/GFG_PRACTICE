class Solution {
    public int remainder(String s) {
        // code here
        int rem=0;
        for(int i=0;i<s.length();i++){
            int digit=s.charAt(i)-'0';//converting char to int value
            rem=(rem*10+digit)%11;
            
        }
        return rem;
    }
}