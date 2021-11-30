package Medium.No721_Account_Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class mergeAccount {
    public static void main(String[] args) {
        List<String> acc1 = Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com");
        List<String> acc2 = Arrays.asList("John","johnsmith@mail.com","john00@mail.com");
        List<String> acc3 = Arrays.asList("Mary","mary@mail.com");
        List<String> acc4 = Arrays.asList("John","johnnybravo@mail.com");
        // List<String> acc4 = Arrays.asList("John","john00@mail.com");

        List<List<String>> accInput = Arrays.asList(acc1, acc2, acc3, acc4);

        List<List<String>> accOutput = accountsMerge(accInput);
        System.out.println(accOutput);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        LinkedHashMap<String, Integer> root_table = new LinkedHashMap<String, Integer>();
        HashMap<Integer, ArrayList<String>> acc_map = new HashMap<Integer, ArrayList<String>>();
        HashMap<Integer, Integer> connect_table = new HashMap<Integer, Integer>();
        HashMap<Integer, String> name_table = new HashMap<Integer, String>();
        ArrayList<List<String>> outAccount = new ArrayList<List<String>>();
        
        for (int acc_no = 0; acc_no < accounts.size(); acc_no++){
            for (String data : accounts.get(acc_no)){
                if (data != accounts.get(acc_no).get(0)){
                    // E-mail
                    if (!root_table.containsKey(data)){
                        // Normal Add
                        root_table.put(data, acc_no);   
                    }else{
                        // Must Find Root
                        connect_table.put(acc_no, root_table.get(data));
                    }
                }else{
                    // Name
                    name_table.put(acc_no, data);
                }
            }
        }

        

        for (String email : root_table.keySet()){
            ArrayList<String> emailList = new ArrayList<String>();

            emailList.add(email);

            int acc_no = root_table.get(email);
            while(connect_table.containsKey(acc_no)){
                acc_no = connect_table.get(acc_no);
            }

            if (acc_map.containsKey(acc_no)){
                emailList.addAll(acc_map.get(acc_no));
            }
            acc_map.put(acc_no, emailList);
        }

        for (int acc_no : acc_map.keySet()){
            List<String> list = new ArrayList<String>(Arrays.asList(name_table.get(acc_no)));
            list.addAll(acc_map.get(acc_no));
            outAccount.add(list);
        }
        return outAccount;
    }
}
