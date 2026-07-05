class Solution {
    public int maxCharGap(String s) {
        // code here
        int first[]=new int[26];
        for(int i=0;i<26;i++){
            first[i]=-1;
        }
        int max=-1;
        for(int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'a';
            if(first[ind]==-1){
                first[ind]=i;
            }
            else
            max=Math.max(max,i-first[ind]-1);
        }
        return max;
    }
}