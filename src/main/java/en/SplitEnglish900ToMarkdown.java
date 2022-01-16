package en;

import util.MyStringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static util.MyStringUtils.addLineSeparator;
import static util.MyStringUtils.addTwoLineSeparator;

public class SplitEnglish900ToMarkdown {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\scofi\\Desktop\\en-sentence\\en-900.txt"));
        StringBuilder english = new StringBuilder();
        StringBuilder mandarin = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (MyStringUtils.startWithChinese(line)) {
                addTwoLineSeparator(english);
                addTwoLineSeparator(english.append(line));
                addTwoLineSeparator(mandarin);
                addTwoLineSeparator(mandarin.append(line));
                continue;
            }

            if(MyStringUtils.startWithNumber(line)){
                int index = MyStringUtils.getIndexOfFirstChinese(line);
                if (index == -1) continue;
                addLineSeparator(english.append(line, 0, index));
                addLineSeparator(mandarin.append(line.substring(index)).append("<br/>"));
            }
        }
//        File file = new File("src/main/resources/properties/test.properties");
        try (PrintWriter englishWriter = new PrintWriter("src/main/resources/en-900-english.md");
             PrintWriter mandarinWriter = new PrintWriter("src/main/resources/en-900-mandarin.md")) {
            englishWriter.println(english);
            mandarinWriter.println(mandarin);
        }
    }
}
