import java.util.Set;

public interface DictionaryService {
    Set<String> getDictionary();

    boolean isEnglishWord(String word);
}
