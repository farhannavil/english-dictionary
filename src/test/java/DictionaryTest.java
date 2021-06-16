import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryTest {
    static DictionaryService dictionaryService;
    static Set<String> dictionaryList;
    static Set<String> validEnglishList;

    public static Set<String> validEnglishWords(String word) throws IOException {
        Set<String> validEnglishWords = new HashSet<>();
        dictionaryList = dictionaryService.getDictionary();
        Set<String> combinations = Combinations.getAllPossibleCombinations(word);
        for (String list : combinations) {
            if (Dictionary.isEnglishWord(list)) {
                validEnglishWords.add(list);
            }
        }
        return validEnglishWords;
    }

    @Before
    public void setUp() {
        dictionaryService = mock(DictionaryService.class);
    }

    @Test
    public void validateWorkingWord() throws IOException {
        validEnglishList = validEnglishWords("working");
        for (String words : validEnglishList) {
            System.out.println(words);
        }
        Assert.assertTrue(Dictionary.isEnglishWord("working"));
    }

    @Test
    public void validateProgrammingWord() throws IOException {
        validEnglishList = validEnglishWords("programming");
        for (String words : validEnglishList) {
            System.out.println(words);
        }
        Assert.assertTrue(Dictionary.isEnglishWord("programming"));
    }

    @Test
    public void validateSdtqocWord() throws IOException {
        validEnglishList = validEnglishWords("Sdtqoc");
        for (String words : validEnglishList) {
            System.out.println(words);
        }
        Assert.assertTrue(Dictionary.isEnglishWord("Sdtqoc"));
    }

}
