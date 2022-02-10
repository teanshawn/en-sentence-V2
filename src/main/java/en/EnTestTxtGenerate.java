package en;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EnTestTxtGenerate {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\scofi\\Desktop\\en-sentence\\sentence.txt"));
        StringBuilder english = new StringBuilder();
        StringBuilder mandarin = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (i % 3 == 0) {
                english.append(lines.get(i)).append(System.lineSeparator()).append(System.lineSeparator());
            }
            if (i % 3 == 1) {
                mandarin.append(lines.get(i)).append(System.lineSeparator()).append(System.lineSeparator());
            }
        }
//        File file = new File("src/main/resources/properties/test.properties");
        try (PrintWriter englishWriter = new PrintWriter("F:\\en-sentence-V2\\src\\main\\resources\\english.txt");
                PrintWriter mandarinWriter = new PrintWriter("F:\\en-sentence-V2\\src\\main\\resources\\mandarin.txt")) {
            englishWriter.println(english);
            mandarinWriter.println(mandarin);
        }
    }
}
