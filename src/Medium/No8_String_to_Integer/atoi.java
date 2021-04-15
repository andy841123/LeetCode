package Medium.No8_String_to_Integer;

import java.util.ArrayList;

public class atoi {
    public static void main(String[] args) {
        // String s = "     +89";
        // String s = "   -42";
        // String s = "4193 with words";
        // String s = "words and 987";
        // String s = "-91283472332";
        // String s = "21474836460";
        String s = "-9223372036854775809";

        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {

        boolean isBegin = false, negative = false;
        long return_i = 0;
        ArrayList<Integer> arrL = new ArrayList<Integer>();

        for (int i_char : s.toCharArray()){
            if (!(i_char==32 || i_char==43 || i_char==45 || (i_char<= 57 && i_char>=48))) break;
            if (i_char == 32 && !isBegin) continue;          
            if ((i_char == 43 || i_char == 45) && !isBegin){
                negative = i_char==45?true:false;
                isBegin = true;
                continue;
            }
            if (!(i_char<=57 && i_char >= 48)) break;
            isBegin = true;
            if (i_char == 48 && arrL.size()==0) continue;
            arrL.add(i_char-48);
        }
        for (int i = 0;i < arrL.size(); i++) return_i += arrL.get(i) * (long)Math.pow(10., arrL.size()-1-i);
        if (arrL.size() > 10){
            return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        if (negative) return_i *= -1;
        if (return_i > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (return_i < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)return_i;
    }
}
