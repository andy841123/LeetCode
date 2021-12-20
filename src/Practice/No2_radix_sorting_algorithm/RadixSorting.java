package Practice.No2_radix_sorting_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSorting {
    public static void main(String[] args) {
        int[] r_list = new int[20];
        for(int i = 0; i < r_list.length;i++){
            r_list[i] = (int)(Math.random()*100 + 1);
        }
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(radix(r_list)));
        long stopTime = System.currentTimeMillis();
        System.out.println("Times: " + (stopTime - startTime) + " ms");
    }

    public static int[] radix(int[] r_list){
        int maxNum = maxNum(r_list);
        int d = digits(maxNum);

        Integer[] I_r_list = Arrays.stream( r_list ).boxed().toArray( Integer[]::new );
        List<Integer> newList = new ArrayList<Integer>();
        newList.addAll(Arrays.asList(I_r_list));

        ArrayList<ArrayList<Integer>> queueList = new ArrayList<ArrayList<Integer>>();
        
        // Init
        for (int i=0; i < 10; i++){
            ArrayList<Integer> queue = new ArrayList<Integer>();
            queueList.add(queue);
        }

        for (int round = 0; round < d; round++){
            while (newList.size() != 0){
                int n  = newList.remove(0);
                queueList.get((n/(int)Math.pow(10, round))%10).add(n);
            }
            for (int q_n = 0; q_n < 10; q_n++){
                newList.addAll(queueList.remove(0));
                queueList.add(new ArrayList<Integer>());
            }
        }
        return newList.stream().mapToInt(i->i).toArray();
    }

    public static int maxNum(int[] list){
        Integer maxN = null;
        for (int n : list){
            if (maxN == null){
                maxN = n;
                continue;
            }
            maxN = Math.max((int)maxN, n);
        }
        return maxN;
    }

    public static int digits(int num){
        int digit = 0;
        int remain = num;
        while (remain != 0){
            digit++;
            remain /= 10;
        }
        return digit;
    }
}