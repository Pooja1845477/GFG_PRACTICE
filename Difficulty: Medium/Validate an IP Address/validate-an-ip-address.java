class Solution {
    public boolean isValid(String s) {

        String arr[] = s.split("\\.", -1);

        if (arr.length != 4)
            return false;

        for (String part : arr) {

            if (part.length() == 0)
                return false;

            if (part.length() > 1 && part.charAt(0) == '0')
                return false;

            for (int i = 0; i < part.length(); i++) {
                if (!Character.isDigit(part.charAt(i)))
                    return false;
            }

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255)
                return false;
        }

        return true;
    }
}