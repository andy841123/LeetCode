package Medium.No721_Account_Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class mergeAccount {
    public static void main(String[] args) {
        List<String> acc1 = Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com");
        List<String> acc2 = Arrays.asList("John","johnsmith@mail.com","john00@mail.com");
        List<String> acc3 = Arrays.asList("Mary","mary@mail.com");
        List<String> acc4 = Arrays.asList("John","johnnybravo@mail.com");

        List<List<String>> accInput = Arrays.asList(acc1, acc2, acc3, acc4);

        List<List<String>> accOutput = accountsMerge(accInput);
        System.out.println(accOutput);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int [] root = new int [4];

        for (int member = 0; member < accounts.size(); member++){
            ListIterator<String> accIt = accounts.get(member).listIterator(1);
            root[member] = member;
            while(accIt.hasNext()){
                System.out.println(accIt.next());
            }
        }
        return null;
    }
}
