import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    public static boolean isEnglishWord(String word) throws IOException {
        Path path = Paths.get("src/test/resources/EnglishWords");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, StandardCharsets.UTF_8);
        String[] words = wordListContents.split("\n");
        Set<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
        return wordsSet.contains(word);
    }
}

