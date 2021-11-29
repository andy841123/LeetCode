package Practice.No1_search_duplicate_number;

public class searchInt {
    public static void main(String[] args) {
        int [] target = {2,4,6,7,9,1,0,15,16,17,18,19,20,11,26,18};
        long startTime = System.nanoTime();
        System.out.println(mySearchDNum(target));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.print("Execute time: " + duration / 1000000. + " ms");
    }

    public static Integer mySearchDNum(int [] ary){
        for (int i = 0; i < ary.length-1; i++){
            for (int j = i+1; j < ary.length; j++){
                if (ary[j] - ary[i] == 0){
                    return ary[i];
                }
            }
        }
        return null;
    }
}