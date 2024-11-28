import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(new File("DataSet/Set.csv"));
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            String[] samples = text.toLowerCase().split(",");
            for (String word : samples[0].split(" ")) {
                System.out.println(samples[1]);
                int coeffcient = (samples[1].equals("positive")) ? 1 : -1;
                words.put(word, (words.containsKey(word) ? words.get(word) + coeffcient : 1 * coeffcient));
            }
        }
        scanner.close();
        System.out.println(words);
    }
}
