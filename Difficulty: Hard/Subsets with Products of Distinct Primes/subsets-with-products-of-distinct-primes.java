class Solution {
    static final int MOD = 1000000007;
    static int[] primes = {2,3,5,7,11,13,17,19,23,29};

    public int countSubsets(int[] arr){

        int ones = 0;
        int[] freq = new int[31];

        for(int x:arr){
            if(x==1) ones++;
            else freq[x]++;
        }

        long[] dp = new long[1<<10];
        dp[0]=1;

        for(int num=2;num<=30;num++){

            if(freq[num]==0) continue;

            int mask=0;
            boolean ok=true;

            int temp=num;

            for(int i=0;i<10;i++){

                int p=primes[i];
                int cnt=0;

                while(temp%p==0){
                    cnt++;
                    temp/=p;
                }

                if(cnt>1){
                    ok=false;
                    break;
                }

                if(cnt==1)
                    mask|=(1<<i);
            }

            if(!ok) continue;

            long[] ndp=dp.clone();

            for(int m=0;m<(1<<10);m++){

                if((m&mask)==0){
                    ndp[m|mask]=(ndp[m|mask]+dp[m]*freq[num])%MOD;
                }
            }

            dp=ndp;
        }

        long ans=0;

        for(int i=1;i<(1<<10);i++)
            ans=(ans+dp[i])%MOD;

        long pow=1;

        for(int i=0;i<ones;i++)
            pow=(pow*2)%MOD;

        ans=(ans*pow)%MOD;

        return (int)ans;
    }

}