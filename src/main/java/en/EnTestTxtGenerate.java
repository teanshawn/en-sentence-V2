package en;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EnTestTxtGenerate {
    public static void main(String[] args) throws IOException {

        System.out.println("start...");
        List<String> lines = Files.readAllLines(Path.of("F:\\en-sentence-V2\\src\\main\\resources\\sentence.txt"), Charset.forName("GBK"));
        StringBuilder english = new StringBuilder();
        StringBuilder mandarin = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        int consecutiveLineBlank = 0;
        for (int i = 0, sentenceCount = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if ("".equals(line))
                consecutiveLineBlank++;
            else consecutiveLineBlank = 0;
            if (consecutiveLineBlank >= 2) return;
            if (i % 3 == 0) {
                appendConditionally(english, line, sentenceCount).append(System.lineSeparator()).append(System.lineSeparator());
                appendConditionally(sentence, line, sentenceCount).append(System.lineSeparator());
            } else if (i % 3 == 1) {
                appendConditionally(mandarin, line, sentenceCount).append(System.lineSeparator()).append(System.lineSeparator());
                appendConditionally(sentence, line, sentenceCount).append(System.lineSeparator());
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

    public static StringBuilder appendConditionally(StringBuilder sb, String line, int sentenceCount) {
        String count = sentenceCount + "";
        String prefix = line.substring(0, count.length());
        if (count.equals(prefix)) {
            return sb.append(line);
        }
        String sentenceCountSeparator = ". ";
        return sb.append(sentenceCount).append(sentenceCountSeparator).append(line);
    }
}
