import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONObject;

public class dataWrite {
    public static void main(String[] args) {
        
        String data = "";
        BufferedReader reader = null;
        Scanner keyboard = new Scanner(System.in);
        FileWriter fw;

        System.out.print("Please enter the Q number: ");
        int num = keyboard.nextInt();
        System.out.print("Please enter the Q file path: ");
        String file_path = keyboard.next();
        


        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("Qlist.txt"), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼
            String str = null;
            while ((str = reader.readLine()) != null) {
                data += str;
            }
            JSONObject jdoc = new JSONObject(data);
            jdoc.put(Integer.toString(num), file_path);
            
            fw = new FileWriter("Qlist.txt");
            fw.write(jdoc.toString());
            fw.flush();
            fw.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        keyboard.close();
    }
}
