import org.json.JSONObject;

public class dataWrite {
    public static void main(String[] args) {
        JSONObject jdoc = new JSONObject();
        jdoc.put("level", "Medium");
        jdoc.put("number", "2");
        jdoc.put("dir_name", "Add_Two_Numbers");
        jdoc.put("file_name", "NL.java");

        System.out.println(jdoc);
    }
}
