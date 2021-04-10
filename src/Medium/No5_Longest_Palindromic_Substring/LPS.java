public class LPS {
    public static void main(String[] args) {
        String s = "babad";
        // System.out.println(s.substring(0,3));
        System.out.println(longPalindromicStr(s));
    }

    static String longPalindromicStr(String s){

        switch(s.length()){
            case 0:
                break;

            case 1:
                break;

            case 2:
                break;

            default:
                for (int i = 0; i < s.length()-2;i++){
                    switch(sameInStr(s.substring(i, i+3))){
                        case 1: //aab or baa
                            break;
                        case 2: //aba
                            break;
                        default:    //abc
                            break;
                    }
                }
                break;
        }
        return "";
    }

    static byte sameInStr(String s){
        byte type = 0;
        for (char c : s.toCharArray()){
            type = s.lastIndexOf(c) - s.indexOf(c)!=0 ? (byte)(s.lastIndexOf(c) - s.indexOf(c));
        }
        return type;
    }
}
