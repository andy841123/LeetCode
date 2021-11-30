package Medium.No18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class fourSum {
    public static void main(String[] args) {
        int [] nums = {2,1,0,-2,-2,0,2};
        int target = 0;
        System.out.println(mfourSum(nums, target));
    }

    public static List<List<Integer>> mfourSum(int[] nums, int target) {
        HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length; k++){
                    List<Integer> list = new ArrayList<Integer>();
                    int v = target - nums[i] - nums[j] - nums[k];
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    map.put(list, v);
                }
            }
        }

        Set<List<Integer>> outSet = new HashSet<List<Integer>>();

        for (List<Integer> intList : map.keySet()){
            ArrayList<Integer> pool = new ArrayList<Integer>();
            pool.addAll(Arrays.asList(Arrays.stream( nums ).boxed().toArray( Integer[]::new )));
            for (Integer n : intList){
                pool.remove(n);
            }
            if (pool.contains(map.get(intList))){
                List<Integer> out = new ArrayList<Integer>();
                out.addAll(intList);
                out.add(map.get(intList));
                Collections.sort(out);
                outSet.add(out);
            }
        }
        
        return outSet.stream().collect(Collectors.toList());
    }
}
