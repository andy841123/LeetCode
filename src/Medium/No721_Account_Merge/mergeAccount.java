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
        AccountList outAcc = new AccountList();
        for (List<String> acc: accounts){
            outAcc.addNext(acc);
        }
        return outAcc.outList();
    }

}

class AccountList{
    List<String> current = null;
    AccountList next = null;

    public AccountList(){
    }

    public AccountList(List<String> acc){
        current = acc;
    }

    public void addNext(List<String> acc){
        if (current == null){
            current = acc;
            return;
        }
        
        if (current.get(0).equals(acc.get(0))){
            ListIterator<String> accIt = acc.listIterator(1);
            ArrayList<String> newAcc = new ArrayList<String>();
            newAcc.addAll(current);
            boolean sameAcc = false;

            while (accIt.hasNext()){
                String accObject = accIt.next();
                if (!current.contains(accObject)){
                    newAcc.add(accObject);
                }
                else{
                    sameAcc = true;
                }
            }

            if (sameAcc) {
                current = newAcc;
                return;
            }
        }

        if (next == null){
            next = new AccountList(acc);
        }else{
            next.addNext(acc);
        }
    }

    public List<List<String>> outList(){
        ArrayList<List<String>> outAccList = new ArrayList<List<String>>();
        outAccList.add(current);
        if (next != null){
            outAccList.addAll(next.outList());
        }
        return outAccList;
    }
}
