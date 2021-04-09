import java.util.Arrays;

public class NL {
    public static void main(String[] args) {
        int [] arr_1 = {9,9,9,9,9,9,9}, arr_2 = {9,9,9,9};
        // int [] arr_1 = {5,6,4}, arr_2 = {2,4,3};

        NodeList nl_1 = gNodeList(arr_1);
        NodeList nl_2 = gNodeList(arr_2);

        NodeList aList = addTwoNodeList(nl_1, nl_2);

        printNodeList(aList);

        
    }

    static NodeList gNodeList(int [] arr_1){

        NodeList nl = new NodeList(arr_1[0]);
        NodeList n = nl;

        for(int elm: Arrays.copyOfRange(arr_1, 1, arr_1.length)){
            n.next = new NodeList(elm);
            n = n.next;
        }
        return nl;
    }

    static NodeList addTwoNodeList(NodeList nl_1, NodeList nl_2){
        NodeList rList = new NodeList( (nl_1.val + nl_2.val) % 10);
        NodeList n = rList, n_nl_1 = nl_1.next, n_nl_2 = nl_2.next;
        int carry = (nl_1.val + nl_2.val) / 10;

        while( !(n_nl_1 == null && n_nl_2 ==  null) || carry != 0){
            if ( (n_nl_1 == null ^ n_nl_2 == null) || carry != 0){
                n_nl_1 = n_nl_1 == null ? new NodeList(0) : n_nl_1;
                n_nl_2 = n_nl_2 == null ? new NodeList(0) : n_nl_2;
            }

            n.next = new NodeList( (n_nl_1.val + n_nl_2.val + carry) % 10);
            carry = (n_nl_1.val + n_nl_2.val + carry) / 10;
            n = n.next;

            n_nl_1 = n_nl_1.next;
            n_nl_2 = n_nl_2.next;
        }

        System.out.println("Carry: " + carry);

        return rList;
    }

    static void printNodeList(NodeList nl){
        NodeList n = nl;
        while( n != null){
            System.out.print(n.val+" ");
            n = n.next;
        }
    }
}

class NodeList{
    int val;
    NodeList next;

    NodeList(int val, NodeList next){
        this.val = val;
        this.next = next;
    }

    NodeList(){
        this.val = 0;
        this.next = null;
    }

    NodeList(int val){
        this.val = val;
        this.next = null;
    }
}
