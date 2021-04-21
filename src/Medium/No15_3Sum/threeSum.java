package Medium.No15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class threeSum {
    public static void main(String[] args) {
        // int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        
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
        Arrays.sort(nums);
        
        int index_f = 0;
        while (index_f < nums.length && nums[index_f] <= 0){
            int index_b = nums.length-1;
            while (index_b > index_f && nums[index_b] >= 0){

                if (nums[index_f] + nums[index_b] > 0){
                    for (int i = index_f+1; nums[i] < 0;i++){
                        if (nums[index_f] + nums[index_b] + nums[i] == 0){
                            return_list.add(Arrays.asList(nums[index_f], nums[i], nums[index_b]));
                            break;
                        } 
                    }
                }else if(nums[index_f] + nums[index_b] < 0){
                    for (int i = index_b-1; nums[i] > 0;i--){
                        if (nums[index_f] + nums[index_b] + nums[i] == 0){
                            return_list.add(Arrays.asList(nums[index_f], nums[i], nums[index_b]));
                            break;
                        } 
                    }
                }else{
                    int index_0 = Arrays.binarySearch(nums, 0);
                    if (index_0 > 0 && index_0 != index_b && index_0 != index_f){
                        return_list.add(Arrays.asList(nums[index_f], 0, nums[index_b]));
                    }
                    if (nums[index_f] == 0 && nums[index_b] == 0) return return_list.stream().distinct().collect(Collectors.toList()); 
                }
                
                index_b--;
            }
            index_f++;
        }

        return return_list.stream().distinct().collect(Collectors.toList());
    }
}
