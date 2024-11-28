import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DataSet/Set.csv"));
        String text = "";
        while (scanner.hasNextLine()) {
            text += scanner.nextLine() + '\n';
        }
        System.out.println(text);
        System.out.println(text.length() - 2);
        text = text.substring(0, text.length());
        FileWriter write = new FileWriter(new File("DataSet/Set.csv"));
        write.write(text);
        scanner.close();
    }
}
