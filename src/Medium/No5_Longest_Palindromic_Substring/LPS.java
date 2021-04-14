package Medium.No5_Longest_Palindromic_Substring;

public class LPS {
    public static void main(String[] args) {
        String s = "";
        // System.out.println(s.substring(0,3));
        System.out.println(longPalindromicStr(s));
    }

    static String longPalindromicStr(String s){
        String convert_buffer = "", origin_buffer, max_string="", buffer_string="";
        char middle_char = ' ';

        for (int i = 0; i < s.length();i++){
            middle_char = s.charAt(i);
            origin_buffer = s.substring(i+1);
            buffer_string = ""+middle_char;
            for (int j = 0; j < convert_buffer.length() && j < origin_buffer.length(); j++){
                if (convert_buffer.charAt(j) != origin_buffer.charAt(j)) break;
                buffer_string = convert_buffer.charAt(j) + buffer_string + origin_buffer.charAt(j);
            }
            max_string  = max_string.length() < buffer_string.length() ? buffer_string : max_string;
            convert_buffer = middle_char + convert_buffer;
            
            buffer_string = "";

            for (int j = 0; j < convert_buffer.length() && j < origin_buffer.length(); j++){
                if (convert_buffer.charAt(j) != origin_buffer.charAt(j)) break;
                buffer_string = convert_buffer.charAt(j) + buffer_string + origin_buffer.charAt(j);
            }
            max_string  = max_string.length() < buffer_string.length() ? buffer_string : max_string;

        }
        return max_string;
    }
}
