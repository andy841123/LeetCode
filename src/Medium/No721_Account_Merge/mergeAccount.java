package Medium.No721_Account_Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        HashMap<String, String> root_table = new HashMap<String, String>();
        HashMap<String, String> name_table = new HashMap<String, String>();

        // 最左邊的account當作root
        for (List<String> acc : accounts) {
            ListIterator<String> emailIt = acc.listIterator(1);
            String root_current = acc.get(1);
            System.out.println(root_current);
            String name = acc.get(0);
            while(emailIt.hasNext()){
                String acc_current = emailIt.next();
                root_table.put(acc_current, root_current);
                name_table.put(acc_current, name);
            }
        }

        System.out.println(root_table);

        ArrayList<List<String>> outAccount = new ArrayList<List<String>>();
        for (String obj : root_table.keySet()) {
            if (root_table.containsValue(obj)){
                ArrayList<String> root_acc = new ArrayList<String>();
                root_acc.add(name_table.get(obj));
                for (String obj1 : root_table.keySet()){
                    if (root_table.get(obj1).equals(obj) && !obj1.equals(obj)) root_acc.add(obj1);
                }
                root_acc.add(obj);
                outAccount.add(root_acc);
            } 
        }
        return outAccount;
    }
}
