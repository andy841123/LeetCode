import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("javac src/Medium/No2_Add_Two_Numbers/NL.java");
        process = Runtime.getRuntime().exec("java src/Medium/No2_Add_Two_Numbers/NL.java");

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        int returnValue = process.waitFor();
        System.out.println(String.format("Return: %d", returnValue));
    }
}
