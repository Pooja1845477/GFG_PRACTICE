class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int freq[]=new int[26];
        int left=0;
        int distinct=0;
        int maxlen=-1;
        for(int right=0;right<s.length();right++){
            int indx=s.charAt(right)-'a';
            if(freq[indx]==0)
            distinct++;
            freq[indx]++;
            while(distinct>k){
                int leftindx=s.charAt(left)-'a';
                freq[leftindx]--;
                if(freq[leftindx]==0)
                distinct--;
                left++;
            }
            if(distinct==k)
            maxlen=Math.max(maxlen,right-left+1);
            
        }
        return maxlen;
    }
} 