package Medium.No16_3Sum_Closest;

import java.util.ArrayList;
import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(method_threeSumClosest(nums, target));
    }

    static int method_threeSumClosest(int[] nums, int target){
        ArrayList<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }

        if (list.contains(target)){
            return target;
        }

        list.add(target);
        list.sort((s2,s1)->-s1.compareTo(s2));
        if (list.indexOf(target) == 0){
            return list.get(1);
        }else if (list.indexOf(target) == list.size()-1){
            return list.get(list.size()-1-1);
        }else{
            if (Math.abs(target- list.get(list.indexOf(target)-1)) > Math.abs(target- list.get(list.indexOf(target)+1))){
                return list.get(list.indexOf(target)+1);
            }else{
                return list.get(list.indexOf(target)-1);
            }
        }
    }
}
