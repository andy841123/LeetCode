import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = null;
        Scanner scanner = new Scanner(System.in);
        String data = "";
        String num;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/Qlist.txt"), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼
            String str = null;
            while ((str = reader.readLine()) != null) {
                data += str;
            }
            JSONObject jdoc = new JSONObject(data);

            System.out.print("Please enter the Q number to run: ");
            num = scanner.next();

            System.out.println("Running Question No"+num+"...");
            System.out.println("Result:\n");

            Process process = Runtime.getRuntime().exec("javac src/"+jdoc.getString(num));
            process = Runtime.getRuntime().exec("java src/"+jdoc.getString(num));

            BufferedReader reader_console = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader_console.readLine()) != null) {
                System.out.println(line);
            }
            int returnValue = process.waitFor();
            System.out.println(String.format("\nTerminal return: %d", returnValue));
            
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

        scanner.close();
        
    }
}
