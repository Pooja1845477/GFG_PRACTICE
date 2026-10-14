class Solution {
    public String findRollOut(String s, int[] roll) {
        // code here
        int n=s.length();
        int m=roll.length;
        int[] count=new int[n];
        //count the effect of each roll
        for(int i=0;i<m;i++){
            count[roll[i]-1]++;
        }
        //calculate total roll for each position
        for(int i=n-2;i>=0;i--){
            count[i]+=count[i+1];
        }
        //Update each characters
        char[] arr=s.toCharArray();
        for(int i=0;i<n;i++){
            int shift =count[i]%26;
            arr[i]=(char)('a'+(arr[i]-'a'+shift)%26);
        }
        return new String(arr);
    }
}