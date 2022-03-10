package en;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EnTestTxtGenerate {
    public static void main(String[] args) throws IOException {
        String sentenceCountSeparator = ". ";
        System.out.println("start...");
        List<String> lines = Files.readAllLines(Path.of("F:\\en-sentence-V2\\src\\main\\resources\\sentence.txt"));
        StringBuilder english = new StringBuilder();
        StringBuilder mandarin = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        for (int i = 0, sentenceCount = 1; i < lines.size(); i++) {
            if (i % 3 == 0) {
                english.append(sentenceCount).append(sentenceCountSeparator).append(lines.get(i)).append(System.lineSeparator()).append(System.lineSeparator());
                sentence.append(sentenceCount).append(sentenceCountSeparator).append(lines.get(i)).append(System.lineSeparator());
            } else if (i % 3 == 1) {
                mandarin.append(sentenceCount).append(sentenceCountSeparator).append(lines.get(i)).append(System.lineSeparator()).append(System.lineSeparator());
                sentence.append(sentenceCount).append(sentenceCountSeparator).append(lines.get(i)).append(System.lineSeparator());
            } else {
                sentenceCount++;
                sentence.append(System.lineSeparator());
            }
        }
//        File file = new File("src/main/resources/properties/test.properties");
        try (PrintWriter englishWriter = new PrintWriter("F:\\en-sentence-V2\\src\\main\\resources\\english.txt");
             PrintWriter mandarinWriter = new PrintWriter("F:\\en-sentence-V2\\src\\main\\resources\\mandarin.txt");
             PrintWriter sentenceWriter = new PrintWriter("F:\\en-sentence-V2\\src\\main\\resources\\sentence.txt")
        ) {
            englishWriter.println(english);
            mandarinWriter.println(mandarin);
            sentenceWriter.println(sentence);
        }
        System.out.println("end...");
    }
}
