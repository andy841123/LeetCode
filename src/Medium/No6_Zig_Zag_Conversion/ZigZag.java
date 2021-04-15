package Medium.No6_Zig_Zag_Conversion;

public class ZigZag {
    public static void main(String[] args) {
        // String s = "PAYPALISHIRING";
        String s = "ab";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    static String convert(String s, int numRows) {
        String[] str_array = new String[numRows];
        String retrun_str = "";
        byte sign = -1;
        int index = 0;
        for (int i = 0; i < numRows; i++) str_array[i] = "";

        for (char c_s : s.toCharArray()){
            str_array[index] += c_s;
            if (index == numRows-1 || index == 0) sign *= -1;
            index += numRows!=1?sign:index; 
        }

        for (String str : str_array) retrun_str += str;
        return retrun_str;
    }
}
