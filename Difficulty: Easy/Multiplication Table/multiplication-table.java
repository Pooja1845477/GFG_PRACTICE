import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        int i=1;
        while(i<=10){
            System.out.print(n*i+" ");
            i++;
        }
    }
}