class Solution {
    public char nthCharacter(int n) {
        // code here
               long digits = 1;
               long start = 1;
               long count = 9;

               while (n > digits * count) {
                   n -= digits * count;
                   digits++;
                   start *= 10;
                   count *= 10;
               }

               long number = start + (n - 1) / digits;
               int index = (int) ((n - 1) % digits);

               String s = String.valueOf(number);
               return s.charAt(index);
           }
}