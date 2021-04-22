package Medium.No17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LCPN {

    private static final Map<String, String> map = new LinkedHashMap<String, String>()
    {{
    put("2","abc");
    put("3","def");
    put("4","ghi");
    put("5","jkl");
    put("6","mno");
    put("7","pqrs");
    put("8","tuv");
    put("9","wxyz");
    }};
    public static void main(String[] args) {
        System.out.println(letterCombinations("79"));
    }

    static List<String> letterCombinations(String digits) {
        List<String> str_list = new ArrayList<String>(); 
        int[] index = new int[digits.length()];

        if (digits.length() == 0) return str_list;

        while(index[digits.length()-1] != map.get(digits.toCharArray()[digits.length()-1]+"").length()){
            String str = "";

            for (int i = 0; i < digits.length(); i++){
                str += map.get(digits.toCharArray()[i]+"").toCharArray()[index[i]];
                // System.out.println(str);
            }

            str_list.add(str);

            index[0]++;

            for (int i = 0; i < digits.length()-1; i++){
                if (index[i] == map.get(digits.toCharArray()[i]+"").length()){
                    index[i] = 0;
                    index[i+1]++;                    
                }
            }
        }

        
        return str_list;
    }
}
