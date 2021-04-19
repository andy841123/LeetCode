package Medium.No12_Integer_to_Roman;

import java.util.LinkedHashMap;
import java.util.Map;


public class ItoR {

    private static final Map<Integer, String> map = new LinkedHashMap<Integer, String>()
    {{
    put(1000,"M");
    put(500,"D");
    put(100,"C");
    put(50,"L");
    put(10,"X");
    put(5,"V");
    put(1,"I");
    }};
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

    static String intToRoman(int num) {
        int r = num, q;
        
        String roman_num = "";

        for (int i=1000; i>0 ; i/=10){
            q = r / i;
            r = (r-q*i) % i;
            roman_num += mapRoman(q, i);
        }
        return roman_num;
    }

    static String mapRoman(int num, int unit){
        String rom_num = "";
        switch(num){
            case 0:
                break;
            case 4:
                rom_num += map.get(unit) + map.get(unit*5);
                break;
            case 5:
                rom_num += map.get(unit*5);
                break;
            case 9:
                rom_num += map.get(unit) + map.get(unit*10);
                break;
            default:
                if (num > 5){
                    rom_num+=map.get(unit*5);
                    for (int i = 0; i<num-5;i++) rom_num+=map.get(unit);
                    
                }else{
                    for (int i = 0; i<num;i++) rom_num+=map.get(unit);
                }
                break;
        }
        return rom_num;
    }
}
