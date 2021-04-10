package Medium.No3_Longest_Substring_Without_Repeating_Characters;

import java.util.ArrayList;

public class nonRepeat {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        //String s = "pwwkew";
        // String s = "aab";
        System.out.println(len_nonRepeat_substring(args[0]));
    }


    static int len_nonRepeat_substring(String s){
        ArrayList<Character> AL = new ArrayList<Character>();
        byte max = 0;

        for (char elm: s.toCharArray()){
            while(AL.contains(elm)) {
                AL.remove(0);
            }
            AL.add(elm);
    
            max = (byte)AL.size() > max ? (byte)AL.size() : max;
        }
        return max;
    }
}
