import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, Float> words = new HashMap<String, Float>();
        HashMap<String, Integer> Occurences = new HashMap<String, Integer>(); 
        Scanner scanner = new Scanner(new File("DataSet/Set.csv"));
        String text = "";
        while (scanner.hasNextLine()) {
            text += scanner.nextLine() + '\n';
        }

        text = text.substring(0, text.length() - 1).toLowerCase();
        String[] samples = text.split("\n");
        for (String sample : samples) {
            String[] items = sample.split(",");
            for (String word : items[0].split(" ")) {
                float coeffcient = (items[1].equals("positive")) ? 1f : -1f;
                words.put(word, words.containsKey(word) ? words.get(word) + coeffcient : 1f * coeffcient);
                Occurences.put(word, Occurences.containsKey(word) ? (int)Occurences.get(word) + 1 : 1);
            }
        }
        for (String word : words.keySet()) {
            word = word.toLowerCase();
            float value = ((float)words.get(word)/(float)Occurences.get(word));
            if (Math.abs(value) < 0.5f) value = 1;
            if (words.get(word) == 0) value = 1;
            words.put(word, value);
        }
        
        scanner.close();
        Scanner inputScanner = new Scanner(System.in);
        String[] input = inputScanner.nextLine().toLowerCase().split(" ");
        float sentiment = 1;
        for (String word : input) {
            if (words.containsKey(word)) sentiment *= (words.get(word) != 0f) ? (words.get(word)) : 1f;
        }
        inputScanner.close();
        System.out.println(sentiment);
    }
}
