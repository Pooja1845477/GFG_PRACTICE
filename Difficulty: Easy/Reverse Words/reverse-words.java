class Solution {
    public String reverseWords(String s) {
        // Code here
        String word[]=s.split("\\.");
        StringBuilder ans=new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            if(!word[i].isEmpty()){
                if(ans.length()>0)
                ans.append(".");
                ans.append(word[i]);
            }
        }
        return ans.toString();
    }
}
