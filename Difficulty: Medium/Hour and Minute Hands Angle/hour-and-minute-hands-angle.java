class Solution {
    public double getAngle(String s) {
        // code here
        int hour=Integer.parseInt(s.substring(0,2));//extracting the hour
        
        int minute=Integer.parseInt(s.substring(3,5));//extracting the minutes 
        //converting 24 hour format to 12 hour format
        hour%=12;
        
        //calculating the minute angle
        double minuteangle=minute*6;
        // calculating the hour angle
        double hourangle=hour*30+minute*0.5;
        
        double angle=Math.abs(hourangle-minuteangle);
        
        return Math.min(angle,360-angle);
    }
}