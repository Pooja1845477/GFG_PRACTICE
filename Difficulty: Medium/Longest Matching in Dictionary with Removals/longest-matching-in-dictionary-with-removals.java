class Solution {
    public String findLongestWord(String s, List<String> d) {
        // code here
        int n=s.length();
        int next[][] =new int[n+1][26];
        for(int c=0;c<26;c++){
            next[n][c]=-1;
            
        }
        for(int i=n-1;i>=0;i--){
            for(int c=0;c<26;c++){
                next[i][c]=next[i+1][c];
            }
            next[i][s.charAt(i)-'a']=i;
        }
        String ans= "";
        for(String word:d){
            int pos=0;
            boolean possible=true;
            for(int i=0;i<word.length();i++){
                int ch=word.charAt(i)-'a';
                
                if(pos>n||next[pos][ch]==-1){
                    possible=false;
                    break;
                }
                pos=next[pos][ch]+1;
            }
            if(possible){
                if(word.length()>ans.length()||(word.length()==ans.length()&& word.compareTo(ans)<0)){
                    ans=word;
                }
            }
        }
        return ans;
    }
}