package Medium.No15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        
        for (List<Integer> l : three_sum(nums)){
            System.out.print('[');
            for (int num : l){
                System.out.print(num+" ");
            }
            System.out.println(']');
        }
    }

    static List<List<Integer>> three_sum(int[] nums) {
        List<List<Integer>> return_list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) map.put(i, nums[i]);
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                HashMap<Integer, Integer> map_clone = (HashMap<Integer, Integer>) map.clone();
                map_clone.remove(i);
                map_clone.remove(j);
                if (map_clone.containsValue(0-nums[i]-nums[j])){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], 0-nums[i]-nums[j]);
                    list.sort((s2, s1) -> -s1.compareTo(s2));
                    return_list.add(list);
                }
            }
        }
        return return_list.stream().distinct().collect(Collectors.toList());
    }
}
